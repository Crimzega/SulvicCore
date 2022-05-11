package com.sulvic.core;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.Sets;
import com.google.common.reflect.TypeToken;
import com.sulvic.core.RegistryList.ObjectEntry;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.IRegList;

@RegibaRegistry
@SuppressWarnings({"serial", "unchecked"})
public class RegistryList<E> implements IRegList<E>, Iterable<ObjectEntry<E>>{
	
	private final TypeToken<Class<?>> token = new TypeToken<Class<?>>(getClass()){};
	private ObjectEntry<E>[] regEntries;
	
	public RegistryList(){ regEntries = new ObjectEntry[0]; }
	
	public Iterator<ObjectEntry<E>> iterator(){ return new RegistryIterator(); }
	
	public E getObject(int index){ return regEntries[index].getObject(); }
	
	public boolean addObject(E e, String name){
		ObjectEntry<E>[] temp = new ObjectEntry[size() + 1];
		System.arraycopy(regEntries, 0, temp, 0, size());
		temp[size()] = new ObjectEntry<E>(e, name);
		regEntries = temp;
		return true;
	}
	
	public E removeObjectById(int id){
		ObjectEntry<E>[] temp = new ObjectEntry[regEntries.length - 1];
		int offset = 0;
		ObjectEntry<E> theEntry = null;
		for(int i = 0; i < temp.length; i++){
			ObjectEntry<E> entry = regEntries[i + offset];
			if(id == i){
				theEntry = entry;
				offset++;
			}
		}
		regEntries = temp;
		return theEntry.getObject();
	}
	
	public E removeObjectByName(String name){
		ObjectEntry<E>[] temp = new ObjectEntry[regEntries.length - 1];
		int offset = 0;
		ObjectEntry<E> theEntry = null;
		for(int i = 0; i < temp.length; i++){
			ObjectEntry<E> entry = regEntries[i + offset];
			if(entry.regName.equals(name)){
				theEntry = entry;
				offset++;
			}
		}
		regEntries = temp;
		return theEntry.getObject();
	}
	
	public boolean objectsAreOf(Class<?> aClass){
		boolean result = aClass.isAssignableFrom(regEntries[0].getObject().getClass());
		for(int i = 1; i < size(); i++){
			result &= aClass.isAssignableFrom(regEntries[i].getObject().getClass());
			if(!result) break;
		}
		return result;
	}
	
	public int size(){ return regEntries.length; }
	
	public Set<E> objectSet(){
		Set<E> set = Sets.newHashSet();
		for(ObjectEntry<E> entry: regEntries) set.add(entry.getObject());
		return set;
	}
	
	public Set<String> nameSet(){
		Set<String> set = Sets.newHashSet();
		for(ObjectEntry<E> entry: regEntries) set.add(entry.getRegistryName());
		return set;
	}
	
	public String getRegistryName(int index){ return regEntries[index].getRegistryName(); }
	
	public Type getType(){ return token.getType(); }
	
	public class RegistryIterator implements Iterator<ObjectEntry<E>>{
		
		int currIndex = 0;
		
		public RegistryIterator(){}
		
		public boolean hasNext(){ return currIndex != size(); }
		
		public ObjectEntry<E> next(){
			ObjectEntry<E> entry = regEntries[currIndex];
			currIndex++;
			return entry;
		}
		
		public void remove(){ removeObjectById(currIndex); }
		
	}
	
	public static class ObjectEntry<E> {
		
		E regItem;
		String regName;
		
		public ObjectEntry(E obj, String name){
			regItem = obj;
			regName = name;
		}
		
		public E getObject(){ return regItem; }
		
		public String getRegistryName(){ return regName; }
		
		public String toString(){
			StringBuilder builder = new StringBuilder();
			builder.append(regItem).append(" (RegName: ").append(regName).append(')');
			return builder.toString();
		}
		
	}
	
}

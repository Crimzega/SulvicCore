package com.sulvic.util;

import static com.sulvic.util.SulvicMath.clampInt;
import static com.sulvic.util.SulvicMath.rangedInt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked"})
public class SulvicCollections{
	
	public static <K, V> K getRandomKey(Map<K, V> map){ return getRandomObject(map.keySet()); }
	
	public static <K, V> V getRandomValue(Map<K, V> map){ return getRandomObject(map.entrySet()).getValue(); }
	
	public static <T> T[] addContentToArray(T[] array, T... extras){
		T[] result = (T[])new Object[array.length + extras.length];
		for(int i = 0; i < array.length; i++) result[i] = array[i];
		for(int i = 0; i < extras.length; i++) result[array.length + i] = extras[i];
		return result;
	}
	
	public static <T> T[] getArrayFromCollection(Collection<T> collection) throws NullPointerException{
		T[] array = (T[])new Object[collection.size()];
		Iterator<T> iterator = collection.iterator();
		int i = 0;
		while(iterator.hasNext()){
			array[i] = (T)iterator.next();
			i++;
		}
		return array;
	}
	
	public static <T> T[] subArray(T[] array, int start, int end){
		if(array == null) return (T[])null;
		start = SulvicMath.maxInt(start, 0);
		end = SulvicMath.minInt(end, array.length);
		int newSize = end - start;
		if(newSize <= 0) return (T[])new Object[0];
		T[] result = (T[])new Object[newSize];
		System.arraycopy(array, start, result, 0, newSize);
		return result;
	}
	
	public static <T> List<T> subList(List<T> list, int start, int end){
		if(list == null) return (List<T>)null;
		start = SulvicMath.maxInt(start, 0);
		end = SulvicMath.minInt(end, list.size());
		int newSize = end-start;
		if(newSize<=0)return new ArrayList<T>();
		List<T> result = new ArrayList<T>();
		for(int i = start; i < end; i++) result.add(list.get(i));
		return result;
	}
	
	public static <T> T getClampedValue(T[] array, int value){ return array[clampInt(value, 0, array.length - 1)]; }
	
	public static <T> T getRandomValue(T[] array){ return array[rangedInt(0, array.length - 1)]; }
	
	public static <T> T getClampedObject(List<T> list, int index){ return list.get(clampInt(index, 0, list.size() - 1)); }
	
	public static <T> T getRandomObject(List<T> list){ return list.get(rangedInt(0, list.size() - 1)); }
	
	public static <T> T getRandomObject(Collection<T> collection){
		int index = rangedInt(0, collection.size() - 1);
		T result = null;
		for(T value: collection){
			if(index == 0) result = value;
			index--;
		}
		return result;
	}
	
	public static <T> T getRandomObject(Set<T> set){ return getRandomObject((Collection<T>)set); }
	
	public static List<Byte> sortedValues(byte... values){
		List<Byte> list = ContentBuilder.newArrayList();
		for(byte value: values) list.add(Byte.valueOf(value));
		Collections.sort(list);
		return list;
	}
	
	public static List<Float> sortedValues(float... values){
		List<Float> list = ContentBuilder.newArrayList();
		for(float value: values) list.add(Float.valueOf(value));
		Collections.sort(list);
		return list;
	}
	
	public static List<Double> sortedValues(double... values){
		List<Double> list = ContentBuilder.newArrayList();
		for(double value: values) list.add(Double.valueOf(value));
		Collections.sort(list);
		return list;
	}
	
	public static List<Long> sortedValues(long... values){
		List<Long> list = ContentBuilder.newArrayList();
		for(long value: values) list.add(Long.valueOf(value));
		Collections.sort(list);
		return list;
	}
	
	public static List<Integer> sortedValues(int... values){
		List<Integer> list = ContentBuilder.newArrayList();
		for(int value: values) list.add(Integer.valueOf(value));
		Collections.sort(list);
		return list;
	}
	
	public static List<Short> sortedValues(short... values){
		List<Short> list = ContentBuilder.newArrayList();
		for(short value: values) list.add(Short.valueOf(value));
		Collections.sort(list);
		return list;
	}
	
}

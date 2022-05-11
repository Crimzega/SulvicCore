package com.sulvic.util;

import java.util.*;

@SuppressWarnings({"unchecked"})
public class ContentBuilder{
	
	public static <T> ArrayList<T> newArrayList(){ return new ArrayList<>(); }
	
	public static <T> ArrayList<T> newArrayList(T... objs){
		ArrayList<T> result = newArrayList();
		for(T obj: objs) result.add(obj);
		return result;
	}
	
	public static <T> LinkedList<T> newLinkedList(){ return new LinkedList<>(); }
	
	public static <T> LinkedList<T> newLinkedList(T... objs){
		LinkedList<T> result = newLinkedList();
		for(T obj: objs) result.add(obj);
		return result;
	}
	
	public static <T> Vector<T> newVector(){ return new Vector<>(); }
	
	public static <T> Vector<T> newVector(T... objs){
		Vector<T> result = newVector();
		for(T obj: objs) result.add(obj);
		return result;
	}
	
	public static <K, V> HashMap<K, V> newHashMap(){ return new HashMap<>(); }
	
	public static <K, V> HashMap<K, V> newHashMap(int size){ return new HashMap<>(); }
	
	public static <K, V> IdentityHashMap<K, V> newIdentityHashMap(){ return new IdentityHashMap<>(); }
	
	public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(){ return new LinkedHashMap<>(); }
	
	public static <K, V> TreeMap<K, V> newTreeMap(){ return new TreeMap<>(); }
	
}

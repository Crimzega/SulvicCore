package com.sulvic.lib;

import org.apache.commons.lang3.builder.HashCodeBuilder;

@SuppressWarnings({"unchecked"})
public class DoubleKeyBasic<K, K1> implements DoubleKeySet<K, K1>{
	
	K firstKey;
	K1 secondKey;
	
	public DoubleKeyBasic(K key, K1 key1){
		firstKey = key;
		secondKey = key1;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof DoubleKeyBasic){
			DoubleKeyBasic<K, K1> keys = (DoubleKeyBasic<K, K1>)obj;
			return isKeySet(keys);
		}
		else return super.equals(obj);
	}
	
	public boolean isKeySet(Object keys){
		if(keys instanceof DoubleKeyBasic){
			DoubleKeyBasic<K, K1> inst = (DoubleKeyBasic<K, K1>)keys;
			return hasKeys(inst.firstKey, inst.secondKey);
		}
		else return false;
	}
	
	public boolean hasKeys(Object key, Object key1){ return firstKey.equals(key) && secondKey.equals(key1); }
	
	public int hashCode(){ return new HashCodeBuilder(9, 25).append(firstKey).append(secondKey).toHashCode(); }
	
	public K getFirstKey(){ return firstKey; }
	
	public K1 getSecondKey(){ return secondKey; }
	
}

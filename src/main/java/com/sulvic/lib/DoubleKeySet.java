package com.sulvic.lib;

public interface DoubleKeySet<K, K1>{
	
	boolean isKeySet(Object obj);
	
	boolean hasKeys(K key, K1 key1);
	
	K getFirstKey();
	
	K1 getSecondKey();
	
}

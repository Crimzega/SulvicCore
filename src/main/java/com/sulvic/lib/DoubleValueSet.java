package com.sulvic.lib;

public interface DoubleValueSet<V, V1>{
	
	boolean isValueSet(Object values);
	
	boolean hasValues(Object value, Object value1);
	
	V getFirstValue();
	
	V1 getSecondValue();
	
	V setFirstValue(V value);
	
	V1 setSecondValue(V1 value1);
	
}

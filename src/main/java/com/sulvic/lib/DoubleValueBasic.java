package com.sulvic.lib;

@SuppressWarnings({"unchecked"})
public class DoubleValueBasic<V, V1> implements DoubleValueSet<V, V1>{
	
	V firstValue;
	V1 secondValue;
	
	public DoubleValueBasic(V value, V1 value1){
		firstValue = value;
		secondValue = value1;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof DoubleValueBasic){
			DoubleValueBasic<V, V1> values = (DoubleValueBasic<V, V1>)obj;
			return isValueSet(values);
		}
		else return super.equals(obj);
	}
	
	public boolean isValueSet(Object values){
		if(values instanceof DoubleValueBasic){
			DoubleValueBasic<V, V1> inst = (DoubleValueBasic<V, V1>)values;
			return hasValues(inst.firstValue, inst.secondValue);
		}
		else return false;
	}
	
	public boolean hasValues(Object value, Object value1){ return firstValue.equals(value) && secondValue.equals(value1); }
	
	public V getFirstValue(){ return firstValue; }
	
	public V1 getSecondValue(){ return secondValue; }
	
	public V setFirstValue(V value){
		V oldValue = firstValue;
		firstValue = value;
		return oldValue;
	}
	
	public V1 setSecondValue(V1 value1){
		V1 oldValue1 = secondValue;
		secondValue = value1;
		return oldValue1;
	}
	
}

package com.sulvic.core.util;

public enum ArmorType{
	
	HELMET,
	CHESTPLATE,
	LEGGINGS,
	BOOTS;
	
	public int getArmorIndex(){ return ordinal(); }
	
	public String getName(){ return name().toLowerCase(); }
	
	public String getUnlocalName(){ return name().substring(0, 1) + name().substring(1).toLowerCase(); }
	
}

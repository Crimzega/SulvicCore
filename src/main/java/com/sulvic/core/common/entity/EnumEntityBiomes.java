package com.sulvic.core.common.entity;

import static net.minecraft.world.biome.BiomeGenBase.*;
import net.minecraft.world.biome.BiomeGenBase;

public enum EnumEntityBiomes{
	
	BROKEN_SKULL,
	UNKNOWN;
	
	public BiomeGenBase[] getBiomes(){
		switch(this){
			case BROKEN_SKULL:
				return new BiomeGenBase[]{forest, forestHills, birchForest, birchForestHills, roofedForest};
			default:
				return new BiomeGenBase[]{plains};
		}
	}
	
}

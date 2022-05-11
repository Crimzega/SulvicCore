package com.sulvic.core.api;

import com.sulvic.core.lib.GemstoneData;
import com.sulvic.core.lib.IGemstone;
import com.sulvic.core.world.gen.WorldVeinGen;
import com.sulvic.core.world.vein.core.IVein;

import net.minecraft.block.material.MapColor;

public class SulvicAPI{
	
	/** Must be used during the creation of a mod for the data to populate during preinitialization phase. */
	public static IGemstone addGemstone(String enumName, final String name, int color, int uses, float damage, float efficiency, int[] reductionAmount, float xp, MapColor mapColor){
		return addGemstone(enumName, name, name, color, uses, damage, efficiency, reductionAmount, xp, mapColor);
	}
	
	/** Must be used during the creation of a mod for the data to populate during preinitialization phase. */
	public static IGemstone addGemstone(String enumName, final String name, final String unlocal, int color, int uses, float damage, float efficiency, int[] reductionAmount, float xp,
		MapColor mapColor){
		return GemstoneData.createGemData(enumName, enumName, unlocal, color, uses, damage, efficiency, reductionAmount, xp, mapColor);
	}
	
	public static void addVein(int dimId, IVein vein){ WorldVeinGen.addGeneratableVein(dimId, vein); }
	
	public static void makeFullRange(int dimId, boolean fullRange){ WorldVeinGen.setFullRangeDimension(dimId, fullRange); }
	
}

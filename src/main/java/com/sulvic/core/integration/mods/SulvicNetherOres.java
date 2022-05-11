package com.sulvic.core.integration.mods;

import com.sulvic.core.common.SulvicObjects;
import com.sulvic.core.common.block.OreGem;
import com.sulvic.core.integration.core.IModHandler;
import com.sulvic.core.integration.core.ModIntegration;
import com.sulvic.core.lib.GemstoneData;
import com.sulvic.core.lib.IGemstone;
import com.sulvic.core.lib.RegibaRegistration;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

@ModIntegration({"NetherOres"})
public class SulvicNetherOres implements IModHandler{
	
	protected static final OreGem NETHER_GEM_ORES = new OreGem().asNetherVariant();
	
	public void postInit(FMLPostInitializationEvent evt){
		RegibaRegistration.registerBlock(NETHER_GEM_ORES);
		for(IGemstone gem: GemstoneData.getGems())
			GameRegistry.addSmelting(new ItemStack(NETHER_GEM_ORES, 1, gem.getMetadata()), new ItemStack(SulvicObjects.GEM_ORES, 2, gem.getMetadata()), 0f);
	}
	
}

package com.sulvic.core.integration.mods;

import com.sulvic.core.common.SulvicObjects;
import com.sulvic.core.integration.core.IModHandler;
import com.sulvic.core.integration.core.ModIntegration;
import com.sulvic.core.integration.item.ItemGemDust;
import com.sulvic.core.lib.GemstoneData;
import com.sulvic.core.lib.IGemstone;
import com.sulvic.core.lib.RegibaRegistration;

import appeng.api.AEApi;
import appeng.api.features.IGrinderRegistry;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.recipe.IMachineRecipeManager;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

public class SulvicDust{
	
	private static final ItemGemDust GEM_DUST = new ItemGemDust();
	
	@ModIntegration({"appliedenergistics2"})
	public static class SulvicAppEng2 implements IModHandler{
		
		public void postInit(FMLPostInitializationEvent evt){
			if(!RegibaRegistration.isRegistered(GEM_DUST)){
				RegibaRegistration.registerItem(GEM_DUST);
				for(IGemstone gem: GemstoneData.getGems()){
					GameRegistry.addSmelting(new ItemStack(GEM_DUST, 1, gem.getMetadata()), new ItemStack(SulvicObjects.GEMS, 1, gem.getMetadata()), 0f);
				}
			}
			IGrinderRegistry grinder = AEApi.instance().registries().grinder();
			for(IGemstone gem: GemstoneData.getGems()){
				grinder.addRecipe(new ItemStack(SulvicObjects.GEM_ORES, 1, gem.getMetadata()), new ItemStack(GEM_DUST, 1, gem.getMetadata()), 8);
				grinder.addRecipe(new ItemStack(SulvicObjects.GEMS, 1, gem.getMetadata()), new ItemStack(GEM_DUST, 1, gem.getMetadata()), 6);
				if(RegibaRegistration.isRegistered(SulvicNetherOres.NETHER_GEM_ORES))
					grinder.addRecipe(new ItemStack(SulvicNetherOres.NETHER_GEM_ORES, 1, gem.getMetadata()), new ItemStack(GEM_DUST, 1, gem.getMetadata()), 16);
			}
		}
		
	}
	
	@ModIntegration({"IC2"})
	public static class SulvicIC2 implements IModHandler{
		
		public void postInit(FMLPostInitializationEvent evt){
			if(!RegibaRegistration.isRegistered(GEM_DUST)){
				RegibaRegistration.registerItem(GEM_DUST);
				for(IGemstone gem: GemstoneData.getGems()) GameRegistry.addSmelting(new ItemStack(GEM_DUST, 1, gem.getMetadata()), new ItemStack(SulvicObjects.GEMS, 1, gem.getMetadata()), 0f);
			}
			IMachineRecipeManager macerator = Recipes.macerator;
			for(IGemstone gem: GemstoneData.getGems()){
				macerator.addRecipe(new RecipeInputItemStack(new ItemStack(SulvicObjects.GEM_ORES, 1, gem.getMetadata())), null, new ItemStack(GEM_DUST, 2, gem.getMetadata()));
				macerator.addRecipe(new RecipeInputItemStack(new ItemStack(SulvicObjects.GEMS, 1, gem.getMetadata())), null, new ItemStack(GEM_DUST, 1, gem.getMetadata()));
				if(RegibaRegistration.isRegistered(SulvicNetherOres.NETHER_GEM_ORES))
					macerator.addRecipe(new RecipeInputItemStack(new ItemStack(SulvicNetherOres.NETHER_GEM_ORES, 1, gem.getMetadata())), null, new ItemStack(GEM_DUST, 4, gem.getMetadata()));
			}
		}
		
	}
	
}

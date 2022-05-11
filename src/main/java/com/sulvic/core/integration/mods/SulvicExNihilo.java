package com.sulvic.core.integration.mods;

import com.sulvic.core.*;
import com.sulvic.core.common.SulvicObjects;
import com.sulvic.core.integration.core.*;
import com.sulvic.core.integration.item.*;
import com.sulvic.core.lib.*;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@ModIntegration({"exnihilo"})
public class SulvicExNihilo implements IModHandler{
	
	private static final String[] HAMMER_RECIPE = {"T  ", " TP", " P "};
	private static final RegistryList<ItemGemHammer> GEM_HAMMERS = SulvicCore.newRegistryList();
	private static final ItemSpecialHammer SPECIAL_HAMMER = new ItemSpecialHammer();
	private static final ItemZechaHammer ZECHA_HAMMER = new ItemZechaHammer();
	
	public void postInit(FMLPostInitializationEvent evt){
		SulvicCore.getLogger().info("Ex Nihilo Handler Extension - " + GemstoneData.size());
		for(IGemstone gem: GemstoneData.getGems()){
			SulvicCore.getLogger().info("Ex Nihilo Extension - " + gem);
			ItemGemHammer hammer = new ItemGemHammer(gem);
			GEM_HAMMERS.addObject(hammer, gem.getName());
			GameRegistry.addShapedRecipe(new ItemStack(hammer), HAMMER_RECIPE, 'T', Items.stick, 'P', new ItemStack(SulvicObjects.GEMS, 1, gem.getMetadata()));
		}
		RegibaRegistration.registerItemList(GEM_HAMMERS);
		RegibaRegistration.registerItem(SPECIAL_HAMMER);
		RegibaRegistration.registerItem(ZECHA_HAMMER);
		for(IGemstone gem: GemstoneData.getGems()){
			ItemGemHammer hammer = GEM_HAMMERS.getObject(gem.getMetadata());
			GameRegistry.addShapedRecipe(new ItemStack(hammer), HAMMER_RECIPE, 'T', Items.stick, 'P', new ItemStack(SulvicObjects.GEMS, 1, gem.getMetadata()));
		}
		GameRegistry.addShapedRecipe(new ItemStack(SPECIAL_HAMMER), HAMMER_RECIPE, 'T', Items.stick, 'P', SulvicObjects.SPECIAL_INGOT);
		GameRegistry.addShapedRecipe(new ItemStack(ZECHA_HAMMER), HAMMER_RECIPE, 'T', Items.stick, 'P', SulvicObjects.ZECHA_INGOT);
	}
	
}

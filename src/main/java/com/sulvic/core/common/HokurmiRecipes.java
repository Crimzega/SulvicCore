package com.sulvic.core.common;

import static com.sulvic.core.common.SulvicObjects.*;

import com.sulvic.core.lib.*;
import com.sulvic.core.util.ArmorType;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class HokurmiRecipes{
	
	private static final String[] SLAB_RECIPE = {"TTT"}, STAIRS_RECIPE = {"  T", " TT", "TTT"}, SMALL_BLOCK_RECIPE = {"TT", "TT"}, FULL_BLOCK_RECIPE = {"TTT", "TTT", "TTT"},
		HELMET_RECIPE = {"TTT", "T T"}, CHESTPLATE_RECIPE = {"T T", "TTT", "TTT"}, LEGGINGS_RECIPE = {"TTT", "T T", "T T"}, BOOTS_RECIPE = {"T T", "T T"}, AXE_RECIPE = {"TT", "TP", " P"},
		HOE_RECIPE = {"TT", " P", " P"}, PICKAXE_RECIPE = {"TTT", " P ", " P "}, SPADE_RECIPE = {"T", "P", "P"}, SWORD_RECIPE = {"T", "T", "P"};
	
	public static void addRecipes(){
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.crafting_table), SMALL_BLOCK_RECIPE, 'T', CITRUS_PLANKS);
		GameRegistry.addShapedRecipe(new ItemStack(CITRUS_SLAB, 3), SLAB_RECIPE, 'T', CITRUS_PLANKS);
		GameRegistry.addShapedRecipe(new ItemStack(CITRUS_STAIRS, 4), STAIRS_RECIPE, 'T', CITRUS_PLANKS);
		for(IGemstone type: GemstoneData.getGems()){
			int gemMetadata = type.getMetadata();
			ItemStack gemStack = new ItemStack(GEMS, 1, gemMetadata);
			GameRegistry.addSmelting(new ItemStack(GEM_ORES, 1, gemMetadata), gemStack, GemstoneData.getGemXP(type));
			GameRegistry.addShapedRecipe(new ItemStack(GEM_BLOCKS, 1, gemMetadata), FULL_BLOCK_RECIPE, 'T', gemStack);
			GameRegistry.addShapelessRecipe(new ItemStack(GEMS, 9, gemMetadata), gemStack);
			Item stick = Items.stick;
			for(ArmorType armor: ArmorType.values()){
				String[] recipe = null;
				switch(armor){
					case HELMET:
						recipe = HELMET_RECIPE;
					break;
					case CHESTPLATE:
						recipe = CHESTPLATE_RECIPE;
					break;
					case LEGGINGS:
						recipe = LEGGINGS_RECIPE;
					break;
					case BOOTS:
						recipe = BOOTS_RECIPE;
					break;
				}
				if(recipe != null) GameRegistry.addShapedRecipe(new ItemStack(getGemArmor(type, armor)), recipe, 'T', gemStack);
			}
			GameRegistry.addShapedRecipe(new ItemStack(getGemSword(type)), SWORD_RECIPE, 'T', gemStack, 'P', stick);
			GameRegistry.addShapedRecipe(new ItemStack(getGemSpade(type)), SPADE_RECIPE, 'T', gemStack, 'P', stick);
			GameRegistry.addShapedRecipe(new ItemStack(getGemPickaxe(type)), PICKAXE_RECIPE, 'T', gemStack, 'P', stick);
			GameRegistry.addShapedRecipe(new ItemStack(getGemAxe(type)), AXE_RECIPE, 'T', gemStack, 'P', stick);
			GameRegistry.addShapedRecipe(new ItemStack(getGemHoe(type)), HOE_RECIPE, 'T', gemStack, 'P', stick);
		}
		GameRegistry.addShapelessRecipe(new ItemStack(CITRUS_PLANKS, 4), CITRUS_LOG);
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.crafting_table), SMALL_BLOCK_RECIPE, 'T', CITRUS_PLANKS);
		GameRegistry.addShapedRecipe(new ItemStack(SPECIAL_BLOCK, 1, 0), SMALL_BLOCK_RECIPE, 'T', SPECIAL_DUST);
		GameRegistry.addShapelessRecipe(new ItemStack(SPECIAL_DUST, 4), new ItemStack(SPECIAL_BLOCK, 1, 0));
		GameRegistry.addShapedRecipe(new ItemStack(SPECIAL_BLOCK, 1, 1), FULL_BLOCK_RECIPE, 'T', SPECIAL_INGOT);
		GameRegistry.addShapelessRecipe(new ItemStack(SPECIAL_INGOT, 9), new ItemStack(SPECIAL_BLOCK, 1, 1));
		GameRegistry.addShapedRecipe(new ItemStack(ENERGY_BAR), new String[]{"TPT", "POP"}, 'T', new ItemStack(Items.dye, 0, 3), 'P', Items.wheat, 'O', Items.sugar);
		for(ArmorType type: ArmorType.values()){
			String[] recipe = null;
			switch(type){
				case HELMET:
					recipe = HELMET_RECIPE;
				break;
				case CHESTPLATE:
					recipe = CHESTPLATE_RECIPE;
				break;
				case LEGGINGS:
					recipe = LEGGINGS_RECIPE;
				break;
				case BOOTS:
					recipe = BOOTS_RECIPE;
				break;
			}
			GameRegistry.addShapedRecipe(new ItemStack(SPECIAL_ARMOR.getObject(type.getArmorIndex())), recipe, 'T', SPECIAL_INGOT, 'P', Items.stick);
			GameRegistry.addShapedRecipe(new ItemStack(ZECHA_ARMOR.getObject(type.getArmorIndex())), recipe, 'T', ZECHA_INGOT, 'P', Items.stick);
		}
		GameRegistry.addSmelting(SPECIAL_DUST, new ItemStack(SPECIAL_INGOT), 0.15f);
		GameRegistry.addSmelting(ZECHA_ORE, new ItemStack(ZECHA_INGOT, 4), 4f);
	}
	
}

package com.sulvic.core.common;

import com.sulvic.core.lib.GemstoneData;
import com.sulvic.core.lib.IGemstone;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

@SuppressWarnings({"deprecation", "unused"})
public class JemurinMaterial{
	
	private static final int HELMET_TRUE = 469 * 16;
	private static final int[] DAMAGE_BASES = {11, 16, 15, 13};
	public static final ArmorMaterial SPECIAL_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("SPECIAL", 467, new int[]{9, 17, 13, 9}, 15);
	public static final ArmorMaterial ZECHA_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("ZECHA", 469, new int[]{11, 19, 15, 11}, 15);
	public static final Material CITRUS_MATERIAL = new Material(MapColor.clayColor);
	public static final Material SPECIAL_MATERIAL = new Material(MapColor.purpleColor);
	public static final Material ZECHA_MATERIAL = new Material(MapColor.yellowColor);
	public static final ToolMaterial SPECIAL_TOOL_MATERIAL = EnumHelper.addToolMaterial("SPECIAL", 4, 6481, 8f, 6.5f, 15);
	public static final ToolMaterial ZECHA_TOOL_MATERIAL = EnumHelper.addToolMaterial("ZECHA", 4, 7167, 9.25f, 7.25f, 15);
	
	public static void addRepairItems(){
		for(IGemstone gem: GemstoneData.getGems()){
			ArmorMaterial armorMat = GemstoneData.getGemArmorMaterial(gem);
			if(armorMat.func_151685_b() == null) armorMat.customCraftingMaterial = SulvicObjects.GEMS;
			ToolMaterial toolMat = GemstoneData.getGemToolMaterial(gem);
			if(toolMat.customCraftingMaterial == null) toolMat.setRepairItem(new ItemStack(SulvicObjects.GEMS, 1, gem.getMetadata()));
		}
		SPECIAL_ARMOR_MATERIAL.customCraftingMaterial = SulvicObjects.SPECIAL_INGOT;
		SPECIAL_TOOL_MATERIAL.setRepairItem(new ItemStack(SulvicObjects.SPECIAL_INGOT));
//		ZECHA_ARMOR_MATERIAL.customCraftingMaterial = SulvicObjects.ZECHA_INGOT;
//		ZECHA_TOOL_MATERIAL.setRepairItem(new ItemStack(SulvicObjects.ZECHA_INGOT));
	}
	
}

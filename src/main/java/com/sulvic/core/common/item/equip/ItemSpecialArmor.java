package com.sulvic.core.common.item.equip;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.util.ArmorType;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemSpecialArmor extends ItemArmor{
	
	private ArmorType armorType;
	
	public ItemSpecialArmor(ArmorType type){
		super(JemurinMaterial.SPECIAL_ARMOR_MATERIAL, 3, type.getArmorIndex());
		setCreativeTab(FolkrumTabs.EQUIP);
		setTextureName(ReferenceSC.MODID + ":armor/special_" + type.getName());
		setUnlocalizedName("special" + type.getUnlocalName());
		armorType = type;
	}
	
	public boolean getIsRepairable(ItemStack stack, ItemStack stack1){ return getArmorMaterial().func_151685_b() == stack1.getItem(); }
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		return ReferenceSC.MODID + ":textures/armor/special_layer" + (armorType == ArmorType.LEGGINGS? 2: 1) + ".png";
	}
	
}

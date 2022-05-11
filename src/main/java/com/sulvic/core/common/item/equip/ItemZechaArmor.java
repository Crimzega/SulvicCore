package com.sulvic.core.common.item.equip;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.util.ArmorType;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemZechaArmor extends ItemArmor{
	
	private ArmorType armorType;
	
	public ItemZechaArmor(ArmorType type){
		super(JemurinMaterial.ZECHA_ARMOR_MATERIAL, 3, type.getArmorIndex());
		setCreativeTab(FolkrumTabs.EQUIP);
		setTextureName(ReferenceSC.MODID + ":armor/zecha_" + type.getName());
		setUnlocalizedName("zecha" + type.getUnlocalName());
		armorType = type;
	}
	
	public boolean getIsRepairable(ItemStack stack, ItemStack stack1){ return getArmorMaterial().func_151685_b() == stack1.getItem(); }
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		return ReferenceSC.MODID + ":textures/armor/zecha_layer" + (armorType == ArmorType.LEGGINGS? 2: 1) + ".png";
	}
	
}

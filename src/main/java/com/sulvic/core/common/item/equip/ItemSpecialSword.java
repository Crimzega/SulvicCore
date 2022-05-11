package com.sulvic.core.common.item.equip;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.item.ItemSword;

@RegibaRegistry
public class ItemSpecialSword extends ItemSword implements INamed{
	
	public ItemSpecialSword(){
		super(JemurinMaterial.SPECIAL_TOOL_MATERIAL);
		setCreativeTab(FolkrumTabs.EQUIP);
		setTextureName(ReferenceSC.MODID + ":tools/special_sword");
		setUnlocalizedName("specialSword");
	}
	
	public String getRegistryName(){ return "special_sword"; }
	
}

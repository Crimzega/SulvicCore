package com.sulvic.core.common.item.equip;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.item.ItemAxe;

@RegibaRegistry
public class ItemSpecialAxe extends ItemAxe implements INamed{
	
	public ItemSpecialAxe(){
		super(JemurinMaterial.SPECIAL_TOOL_MATERIAL);
		setCreativeTab(FolkrumTabs.TOOLS);
		setTextureName(ReferenceSC.MODID + ":tools/special_axe");
		setUnlocalizedName("specialAxe");
	}
	
	public String getRegistryName(){ return "special_axe"; }
	
}

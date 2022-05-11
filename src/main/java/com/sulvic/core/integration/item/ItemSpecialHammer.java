package com.sulvic.core.integration.item;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import exnihilo.items.hammers.ItemHammerBase;

@RegibaRegistry
public class ItemSpecialHammer extends ItemHammerBase implements INamed{
	
	public ItemSpecialHammer(){
		super(JemurinMaterial.SPECIAL_TOOL_MATERIAL);
		setCreativeTab(FolkrumTabs.TOOLS);
		setTextureName(ReferenceSC.MODID + ":tools/special_hammer");
		setUnlocalizedName("specialHammer");
	}
	
	public String getRegistryName(){ return "special_hammer"; }
	
}

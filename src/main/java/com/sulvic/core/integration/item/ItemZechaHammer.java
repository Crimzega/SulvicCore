package com.sulvic.core.integration.item;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import exnihilo.items.hammers.ItemHammerBase;

@RegibaRegistry
public class ItemZechaHammer extends ItemHammerBase implements INamed{
	
	public ItemZechaHammer(){
		super(JemurinMaterial.ZECHA_TOOL_MATERIAL);
		setCreativeTab(FolkrumTabs.TOOLS);
		setTextureName(ReferenceSC.MODID + ":tools/zecha_axe");
		setUnlocalizedName("zechaAxe");
	}
	
	public String getRegistryName(){ return "zecha_hammer"; }
	
}

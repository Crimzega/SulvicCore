package com.sulvic.core.common.item.equip;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.item.ItemAxe;

@RegibaRegistry
public class ItemZechaAxe extends ItemAxe implements INamed{
	
	public ItemZechaAxe(){
		super(JemurinMaterial.ZECHA_TOOL_MATERIAL);
		setCreativeTab(FolkrumTabs.TOOLS);
		setTextureName(ReferenceSC.MODID + ":tools/zecha_axe");
		setUnlocalizedName("zechaAxe");
	}
	
	public String getRegistryName(){ return "zecha_axe"; }
	
}

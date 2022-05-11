package com.sulvic.core.common.item.equip;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.item.ItemPickaxe;

@RegibaRegistry
public class ItemZechaPickaxe extends ItemPickaxe implements INamed{
	
	public ItemZechaPickaxe(){
		super(JemurinMaterial.ZECHA_TOOL_MATERIAL);
		setCreativeTab(FolkrumTabs.TOOLS);
		setTextureName(ReferenceSC.MODID + ":tools/zecha_pickaxe");
		setUnlocalizedName("zechaPickaxe");
	}
	
	public String getRegistryName(){ return "zecha_pickaxe"; }
	
}

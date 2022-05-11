package com.sulvic.core.common.item.equip;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.item.ItemPickaxe;

@RegibaRegistry
public class ItemSpecialPickaxe extends ItemPickaxe implements INamed{
	
	public ItemSpecialPickaxe(){
		super(JemurinMaterial.SPECIAL_TOOL_MATERIAL);
		setCreativeTab(FolkrumTabs.TOOLS);
		setTextureName(ReferenceSC.MODID + ":tools/special_pickaxe");
		setUnlocalizedName("specialPickaxe");
	}
	
	public String getRegistryName(){ return "special_pickaxe"; }
	
}

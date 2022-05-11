package com.sulvic.core.common.item;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.item.Item;

@RegibaRegistry
public class ItemZechaIngot extends Item implements INamed{
	
	public ItemZechaIngot(){
		setCreativeTab(FolkrumTabs.BLOCKS);
		setTextureName(ReferenceSC.MODID + ":zecha_ingot");
		setUnlocalizedName("zechaIngot");
	}
	
	public String getRegistryName(){ return "zecha_ingot"; }
	
}

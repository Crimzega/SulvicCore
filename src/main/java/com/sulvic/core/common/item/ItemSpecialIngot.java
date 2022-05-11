package com.sulvic.core.common.item;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.item.Item;

@RegibaRegistry
public class ItemSpecialIngot extends Item implements INamed{
	
	public ItemSpecialIngot(){
		super();
		setCreativeTab(FolkrumTabs.ITEMS);
		setTextureName(ReferenceSC.MODID + ":special_ingot");
		setUnlocalizedName("specialIngot");
	}
	
	public String getRegistryName(){ return "special_ingot"; }
	
}

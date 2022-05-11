package com.sulvic.core.common.item;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.item.Item;

@RegibaRegistry
public class ItemSpecialDust extends Item implements INamed{
	
	public ItemSpecialDust(){
		setCreativeTab(FolkrumTabs.ITEMS);
		setTextureName(ReferenceSC.MODID + ":special_dust");
		setUnlocalizedName("specialDust");
	}
	
	public String getRegistryName(){ return "special_dust"; }
	
}

package com.sulvic.core.common.item.food;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.item.ItemFood;

@RegibaRegistry
public class ItemEnergyBar extends ItemFood implements INamed{
	
	public ItemEnergyBar(){
		super(5, 2.25f, true);
		setCreativeTab(FolkrumTabs.FOOD);
		setTextureName(ReferenceSC.MODID + ":snacks/energy_bar");
		setUnlocalizedName("energyBar");
	}
	
	public String getRegistryName(){ return "energy_bar"; }
	
}

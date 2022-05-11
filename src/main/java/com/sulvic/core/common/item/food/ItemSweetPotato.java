package com.sulvic.core.common.item.food;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.SulvicObjects;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeedFood;

@RegibaRegistry
public class ItemSweetPotato extends ItemSeedFood implements INamed{
	
	public ItemSweetPotato(){
		super(1, 0.45f, SulvicObjects.SWEET_POTATO_CROP, Blocks.farmland);
		setCreativeTab(FolkrumTabs.FOOD);
		setTextureName(ReferenceSC.MODID + ":snacks/sweet_potato");
		setUnlocalizedName("sweetPotato");
	}
	
	public String getRegistryName(){ return "sweet_potato"; }
	
}

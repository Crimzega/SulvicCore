package com.sulvic.core.integration;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.SulvicObjects;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import net.minecraft.item.ItemStack;

public class NEISulvicConfig implements IConfigureNEI{
	
	public String getName(){ return ReferenceSC.NAME + " NEI Plugin"; }
	
	public String getVersion(){ return ReferenceSC.MODID; }
	
	public void loadConfig(){
		API.hideItem(new ItemStack(SulvicObjects.SWEET_POTATO_CROP));
		API.hideItem(new ItemStack(SulvicObjects.SUGAR_PILE));
		// API.hideItem(new ItemStack(SulvicObjects.BURNT_SUGAR_PILE));
	}
	
}

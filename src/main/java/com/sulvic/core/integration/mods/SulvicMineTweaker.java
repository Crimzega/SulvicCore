package com.sulvic.core.integration.mods;

import com.sulvic.core.integration.core.IModHandler;
import com.sulvic.core.integration.core.ModIntegration;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;

@ModIntegration({"MineTweaker3"})
public class SulvicMineTweaker implements IModHandler{
	
	public void postInit(FMLPostInitializationEvent evt){
//		MineTweakerAPI.registerClassRegistry(ZenWrench.class);
//		MineTweakerAPI.registerClassRegistry(ZenOreDetector.class);
	}
	
}

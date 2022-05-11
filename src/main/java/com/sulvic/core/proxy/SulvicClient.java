package com.sulvic.core.proxy;

import com.sulvic.core.client.render.RenderBrokenSkull;
import com.sulvic.core.common.SulvicObjects;
import com.sulvic.core.common.entity.EntityBrokenSkull;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class SulvicClient extends AlvontixProxy{
	
	public void registerRenders(){
		RenderingRegistry.registerEntityRenderingHandler(EntityBrokenSkull.class, new RenderBrokenSkull());
	}
	
	public void setFancyRender(boolean fancy){ SulvicObjects.setFancyTextures(fancy); }
	
}

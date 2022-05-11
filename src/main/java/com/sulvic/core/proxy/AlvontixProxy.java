package com.sulvic.core.proxy;

import net.minecraft.client.Minecraft;

public class AlvontixProxy{
	
	private static boolean isFancy = Minecraft.isFancyGraphicsEnabled();
	
	public boolean isFancyGraphics(){ return isFancy; }
	
	public void registerRenders(){}
	
	public void setFancyRender(boolean fancy){ isFancy = Minecraft.getMinecraft().gameSettings.fancyGraphics = fancy; }
	
}

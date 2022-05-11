package com.sulvic.core.client.config;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Property;

public class ConfigCore extends BezkinConfig{
	
	private String[] pileBlocks;
	private int biomeId;
	
	public ConfigCore(FMLPreInitializationEvent evt, String name){ super(evt, name); }
	
	public ConfigCore(FMLPreInitializationEvent evt, String name, boolean caseSensitive){ super(evt, name, caseSensitive); }
	
	public ConfigCore(FMLPreInitializationEvent evt, String name, String version){ super(evt, name, version); }
	
	public ConfigCore(FMLPreInitializationEvent evt, String name, String version, boolean caseSensitive){ super(evt, name, version, caseSensitive); }
	
	protected void makeConfig(){
		biomeId = getInt("biomeId", CFG_BASE + ".world", 200, 150, 380, "The starting point for biomes using this mod", "config.biomeId. example: modid:blockname");
		Property property = get("", "pileBlocks", new String[0]);
		property.setLanguageKey("config.pileBlocks");
		property.comment = "Adds block for piles to be allowed on.";
		pileBlocks = property.getStringList();
	}
	
	public String[] getPileBlocks(){ return pileBlocks; }
	
	public int getBiomeId(){ return biomeId; }
	
}

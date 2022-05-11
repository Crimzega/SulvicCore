package com.sulvic.core.client.config;

import java.io.File;

import com.sulvic.core.logger.MezidaLogger;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public abstract class BezkinConfig extends Configuration{
	
	protected static final String CFG_BASE = "sulvic";
	protected static MezidaLogger configLog = new MezidaLogger("Bezking Config Handler");
	
	public BezkinConfig(FMLPreInitializationEvent evt, String name){ super(setupModFile(evt, name)); }
	
	public BezkinConfig(FMLPreInitializationEvent evt, String name, boolean caseSensitive){ super(setupModFile(evt, name), caseSensitive); }
	
	public BezkinConfig(FMLPreInitializationEvent evt, String name, String version){ super(setupModFile(evt, name), version); }
	
	public BezkinConfig(FMLPreInitializationEvent evt, String name, String version, boolean caseSensitive){ super(setupModFile(evt, name), version, caseSensitive); }
	
	private static File setupModFile(FMLPreInitializationEvent evt, String name){ return new File(evt.getModConfigurationDirectory(), name); }
	
	protected abstract void makeConfig();
	
	public void buildConfig(){
		try{
			load();
			makeConfig();
		}
		catch(Exception ex){
			configLog.catching(ex);
		}
		finally{
			if(hasChanged()) save();
		}
		
	}
	
}

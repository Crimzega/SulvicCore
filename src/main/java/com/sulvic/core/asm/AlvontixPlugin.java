package com.sulvic.core.asm;

import java.util.Map;

import org.apache.logging.log4j.*;

import cpw.mods.fml.relauncher.*;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.*;
import net.minecraft.launchwrapper.IClassTransformer;

@MCVersion("1.7.10")
@DependsOn({"forge"})
@SortingIndex(1000)
@TransformerExclusions({"com.sulvic.core.asm.*"})
public class AlvontixPlugin implements IClassTransformer, IFMLLoadingPlugin{
	
	protected static boolean isObfuscated;
	protected static Logger logger = LogManager.getLogger("Alvontix Transformer");
	
	private byte[] transformItems(byte[] basicClass){
		
		return basicClass;
	}
	
	public byte[] transform(String name, String transformedName, byte[] basicClass){
		if(transformedName.equals("net.minecraft.item.Item")) return transformItems(basicClass);
		return basicClass;
	}
	
	public String[] getASMTransformerClass(){ return null; }
	
	public String getAccessTransformerClass(){ return getClass().getName(); }
	
	public String getModContainerClass(){ return null; }
	
	public String getSetupClass(){ return null; }
	
	public void injectData(Map<String, Object> data){
		isObfuscated = (Boolean)data.get("runtimeDeobfuscationEnabled");
		logger.info("Classes are obfuscated: {}", isObfuscated);
	}
	
}

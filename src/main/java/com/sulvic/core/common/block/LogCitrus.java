package com.sulvic.core.common.block;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

@RegibaRegistry
public class LogCitrus extends BlockLog implements INamed{
	
	public LogCitrus(){
		setCreativeTab(FolkrumTabs.BLOCKS);
		setBlockName("logCitrus");
		setHarvestLevel("axe", 0);
	}
	
	public String getRegistryName(){ return "citrus_log"; }
	
	public void registerBlockIcons(IIconRegister registry){
		field_150166_b = new IIcon[]{registry.registerIcon(ReferenceSC.MODID + ":citrus/log_top")};
		field_150167_a = new IIcon[]{registry.registerIcon(ReferenceSC.MODID + ":citrus/log_side")};
	}
	
}

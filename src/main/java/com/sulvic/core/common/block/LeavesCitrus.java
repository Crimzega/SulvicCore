package com.sulvic.core.common.block;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.handler.SulvicMasterHandler;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;
import com.sulvic.core.proxy.AlvontixClient;
import com.sulvic.core.proxy.IFancy;

import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

@RegibaRegistry
public class LeavesCitrus extends BlockLeaves implements IFancy, INamed{
	
	@AlvontixClient
	private static final String[][] TEXTURE_BASES = {{"citrus/leaves"}, {"citrus/leaves_opaque"}};
	
	public LeavesCitrus(){
		setBlockName("leavesCitrus");
		setCreativeTab(FolkrumTabs.BLOCKS);
		setGraphicsLevel(SulvicMasterHandler.usingFancyGraphics());
	}
	
	public IIcon getIcon(int metadata, int side){ return field_150129_M[field_150127_b][0]; }
	
	public String[] func_150125_e(){ return new String[]{"citrus"}; }
	
	public String getRegistryName(){ return "citrus_leaves"; }
	
	@AlvontixClient
	public void setFancyGraphics(boolean fancy){ setGraphicsLevel(fancy); }
	
	@AlvontixClient
	public void registerBlockIcons(IIconRegister registry){
		for(int i = 0; i < TEXTURE_BASES.length; i++){
			field_150129_M[i] = new IIcon[TEXTURE_BASES[i].length];
			for(int j = 0; j < field_150129_M[i].length; j++) field_150129_M[i][j] = registry.registerIcon(ReferenceSC.MODID + ":" + TEXTURE_BASES[i][j]);
		}
	}
	
}

package com.sulvic.core.common.block;

import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.SulvicObjects;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.block.BlockStairs;

@RegibaRegistry
public class StairsCitrus extends BlockStairs implements INamed{
	
	public StairsCitrus(){
		super(SulvicObjects.CITRUS_PLANKS, 0);
		setCreativeTab(FolkrumTabs.BLOCKS);
		setBlockName("citrusStiars");
	}
	
	public String getRegistryName(){ return "citrus_stairs"; }
	
}

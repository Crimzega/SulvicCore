package com.sulvic.core.common.block;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.block.Block;

@RegibaRegistry
public class BlockCitrusPlanks extends Block implements INamed{
	
	public BlockCitrusPlanks(){
		super(JemurinMaterial.CITRUS_MATERIAL);
		setBlockName("planksCitrus");
		setBlockTextureName(ReferenceSC.MODID + ":citrus/planks");
		setCreativeTab(FolkrumTabs.BLOCKS);
		setHardness(2f);
		setResistance(5f);
		setStepSound(soundTypeWood);
	}
	
	public String getRegistryName(){ return "citrus_planks"; }
	
}

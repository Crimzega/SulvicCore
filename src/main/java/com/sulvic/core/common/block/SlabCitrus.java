package com.sulvic.core.common.block;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.common.SulvicObjects;
import com.sulvic.core.common.item.block.ItemCitrusSlab;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.IBlock;
import com.sulvic.core.lib.RegibaRegistry.IItemArgs;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemBlock;

@RegibaRegistry
public class SlabCitrus extends BlockSlab implements IBlock, INamed, IItemArgs{
	
	public SlabCitrus(boolean full){
		super(full, JemurinMaterial.CITRUS_MATERIAL);
		setBlockName("citrusSlab");
		setBlockTextureName(ReferenceSC.MODID + ":citrus/planks");
		if(!full){
			setCreativeTab(FolkrumTabs.BLOCKS);
			setLightOpacity(0);
		}
		else setLightOpacity(255);
	}
	
	public Class<? extends ItemBlock> itemClass(){ return ItemCitrusSlab.class; }
	
	public Object[] ctorArgs(){ return new Object[]{SulvicObjects.CITRUS_SLAB, SulvicObjects.CITRUS_DOUBLE_SLAB, field_150004_a}; }
	
	public String func_150002_b(int metadata){ return getUnlocalizedName(); }
	
	public String getRegistryName(){ return field_150004_a? "citrus_slab": "citrus_slab_double"; }
	
}

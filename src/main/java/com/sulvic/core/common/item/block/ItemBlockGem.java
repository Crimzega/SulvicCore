package com.sulvic.core.common.item.block;

import com.sulvic.core.lib.GemstoneData;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockGem extends ItemBlock{
	
	public ItemBlockGem(Block gem){
		super(gem);
		setHasSubtypes(true);
	}
	
	public int getMetadata(int metadata){ return metadata; }
	
	public String getUnlocalizedName(ItemStack stack){
		int metadata = stack.getItemDamage();
		if(metadata < 0 || metadata >= GemstoneData.size()) metadata = 0;
		return getUnlocalizedName() + '.' + GemstoneData.byMetadata(metadata).getUnlocalName();
	}
	
}

package com.sulvic.core.common.item.block;

import com.sulvic.core.common.block.SlabCitrus;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemCitrusSlab extends ItemSlab{
	
	public ItemCitrusSlab(Block block, SlabCitrus half, SlabCitrus full, Boolean isFull){ super(block, half, full, isFull.booleanValue()); }
	
}

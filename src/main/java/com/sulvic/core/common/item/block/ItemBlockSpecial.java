package com.sulvic.core.common.item.block;

import net.minecraft.block.Block;
import net.minecraft.item.*;

public class ItemBlockSpecial extends ItemBlock{
	
	public ItemBlockSpecial(Block block){
		super(block);
		setHasSubtypes(true);
	}
	
	public int getMetadata(int metadata){ return metadata; }
	
	public String getUnlocalizedName(ItemStack stack){
		int metadata = stack.getItemDamage();
		if(metadata < 0 || metadata > 1) metadata = 0;
		return super.getUnlocalizedName() + "." + (metadata == 0? "dust": "metal");
	}
	
}

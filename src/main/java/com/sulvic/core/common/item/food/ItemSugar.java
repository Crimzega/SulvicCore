package com.sulvic.core.common.item.food;

import com.sulvic.core.common.SulvicObjects;
import com.sulvic.core.handler.SulvicMasterHandler;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSugar extends ItemFood{
	
	public ItemSugar(){ super(3, 1.5f, false); }
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			Block block = world.getBlock(x, y, z);
			if(SulvicMasterHandler.isPileOnTopOf(block) && world.isAirBlock(x, y + 1, z)){
				world.setBlock(x, y + 1, z, SulvicObjects.SUGAR_PILE);
				if(player.capabilities.isCreativeMode) stack.stackSize--;
			}
			return true;
		}
		return true;
	}
	
}

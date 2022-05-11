package com.sulvic.core.world.gen.tree;

import java.util.Random;

import com.sulvic.core.common.SulvicObjects;
import com.sulvic.core.world.gen.WorldGenSulvicTree;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class CitrusTreeGen extends WorldGenSulvicTree{
	
	public CitrusTreeGen(boolean notify){ super(notify, 4, SulvicObjects.CITRUS_LOG, SulvicObjects.CITRUS_LEAVES, SulvicObjects.CITRUS_SAPLING); }
	
	public boolean generate(World world, Random rand, int x, int y, int z){
		int height = rand.nextInt(3) + minTreeHeight;
		boolean flag = true;
		if(y >= 1 && y + height + 1 <= 256){
			byte b;
			Block block;
			for(int y_ = y; y_ <= y + 1 + height; y_++){
				b = (byte)((y_ == y)? 0: (y_ >= y + 1 + height - 2)? 2: 1);
				for(int x_ = x - b; x_ <= x + b && flag; x_++) for(int z_ = z - b; z_ <= z + b && flag; z_++){
					if(y_ >= 0 && y_ < 256){
						block = world.getBlock(x_, y_, z_);
						if(!isReplaceable(world, x_, y_, z_)) flag = false;
					}
					else flag = false;
				}
			}
			if(!flag) return false;
			else{
				Block blockBelow = world.getBlock(x, y - 1, z);
				if(blockBelow.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, (BlockSapling)Blocks.sapling) && y < 256 - height - 1){
					blockBelow.onPlantGrow(world, x, y - 1, z, x, y, z);
					b = 3;
					byte b1 = 0;
					int check, xOff, yOff;
					for(int y_ = y - b + height; y_ <= y + height; y_++){
						yOff = y_ - (y + height);
						check = b1 + 1 - yOff / 2;
						for(int x_ = x - check; x_ <= x + check; x_++){
							xOff = x_ - x;
							for(int z_ = z - check; z_ <= z + check; z_++){
								int zOff = z_ - z;
								if(Math.abs(xOff) != check || Math.abs(zOff) != check || rand.nextInt(2) != 0 && yOff != 0){
									Block block1 = world.getBlock(x_, y_, z_);
									if(block1.isAir(world, x_, y_, z_) || block1.isLeaves(world, x_, y_, z_)) setBlockAndNotifyAdequately(world, x_, y_, z_, blockLeaves, 0);
								}
							}
						}
					}
					for(int y_ = 0; y_ < height; y_++){
						block = world.getBlock(x, y + y_, z);
						if(block.isAir(world, x, y + y_, z) || block.isLeaves(world, x, y + y_, z) || block == blockSapling) setBlockAndNotifyAdequately(world, x, y + y_, z, blockLog, 0);
					}
					return true;
				}
				else return false;
			}
		}
		else return false;
	}
	
}

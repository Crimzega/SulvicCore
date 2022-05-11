package com.sulvic.core.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class EndGenMinable extends WorldGenerator{
	
	private Block chosenBlock;
	private int numberOfBlocks;
	private Block targetBlock;
	private int mineableBlockMeta;
	
	public EndGenMinable(Block block, int amount){ this(block, amount, Blocks.end_stone); }
	
	public EndGenMinable(Block block, int amount, Block target){
		chosenBlock = block;
		numberOfBlocks = amount;
		targetBlock = target;
	}
	
	public EndGenMinable(Block block, int meta, int number, Block target){
		this(block, number, target);
		mineableBlockMeta = meta;
	}
	
	public boolean generate(World world, Random rand, int x, int y, int z){
		float f = rand.nextFloat() * (float)Math.PI;
		double x1 = (double)((float)(x + 8) + MathHelper.sin(f) * (float)numberOfBlocks / 8f);
		double x2 = (double)((float)(x + 8) - MathHelper.sin(f) * (float)numberOfBlocks / 8f);
		double z1 = (double)((float)(z + 8) + MathHelper.cos(f) * (float)numberOfBlocks / 8f);
		double z2 = (double)((float)(z + 8) - MathHelper.cos(f) * (float)numberOfBlocks / 8f);
		double y1 = (double)(y + rand.nextInt(3) - 2);
		double y2 = (double)(y + rand.nextInt(3) - 2);
		for(int i = 0; i <= numberOfBlocks; i++){
			double x_ = x1 + (x2 - x1) * (double)i / (double)numberOfBlocks;
			double y_ = y1 + (y2 - y1) * (double)i / (double)numberOfBlocks;
			double z_ = z1 + (z2 - z1) * (double)i / (double)numberOfBlocks;
			double d9 = rand.nextDouble() * (double)numberOfBlocks / 16d;
			double d10 = (double)(MathHelper.sin((float)i * (float)Math.PI / (float)numberOfBlocks) + 1f) * d9 + 1d;
			double d11 = (double)(MathHelper.sin((float)i * (float)Math.PI / (float)numberOfBlocks) + 1f) * d9 + 1d;
			int minX = MathHelper.floor_double(x_ - d10 / 2d);
			int minY = MathHelper.floor_double(y_ - d11 / 2d);
			int minZ = MathHelper.floor_double(z_ - d10 / 2d);
			int maxX = MathHelper.floor_double(x_ + d10 / 2d);
			int maxY = MathHelper.floor_double(y_ + d11 / 2d);
			int maxZ = MathHelper.floor_double(z_ + d10 / 2d);
			for(int x__ = minX; x__ <= maxX; x__++){
				double x1_ = ((double)x__ + 0.5d - x_) / (d10 / 2d);
				if(x1_ * x1_ < 1d) for(int y__ = minY; y__ <= maxY; y__++){
					double y1_ = ((double)y__ + 0.5d - y_) / (d11 / 2d);
					if(x1_ * x1_ + y1_ * y1_ < 1d) for(int z__ = minZ; z__ <= maxZ; z__++){
						double z1_ = ((double)z__ + 0.5d - z_) / (d10 / 2d);
						if(x1_ * x1_ + y1_ * y1_ + z1_ * z1_ < 1d && world.getBlock(x__, y__, z__).isReplaceableOreGen(world, x__, y__, z__, targetBlock))
							world.setBlock(x__, y__, z__, chosenBlock, mineableBlockMeta, 2);
					}
				}
			}
		}
		return true;
	}
	
}

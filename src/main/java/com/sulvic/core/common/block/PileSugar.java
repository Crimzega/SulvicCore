package com.sulvic.core.common.block;

import java.util.Random;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.handler.SulvicMasterHandler;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

@RegibaRegistry
public class PileSugar extends Block implements INamed{
	
	public PileSugar(){
		super(Material.snow);
		setBlockBounds(0f, 0f, 0f, 1f, 0.015625f, 1f);
		setBlockName("sugarPile");
		setBlockTextureName(ReferenceSC.MODID + ":sugar");
		setStepSound(soundTypeCloth);
	}
	
	protected boolean canPlaceBlockOn(Block block){ return SulvicMasterHandler.isPileOnTopOf(block); }
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){ return super.getCollisionBoundingBoxFromPool(world, x, y, z); }
	
	public boolean canBlockStay(World world, int x, int y, int z){ return y >= 0 && y < 256? canPlaceBlockOn(world.getBlock(x, y - 1, z)): false; }
	
	public boolean isOpaqueCube(){ return false; }
	
	public boolean renderAsNormalBlock(){ return false; }
	
	public int getRenderType(){ return 23; }
	
	public int quantityDropped(Random rand){ return 1; }
	
	public Item getItemDropped(int metadata, Random random, int fortune){ return Items.sugar; }
	
	public String getRegistryName(){ return "sugar_pile"; }
	
}

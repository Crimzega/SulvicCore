package com.sulvic.core.common.block;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.IBlockAccess;

@RegibaRegistry
public class OreZecha extends Block implements INamed{
	
	public OreZecha(){
		super(Material.rock);
		setCreativeTab(FolkrumTabs.BLOCKS);
		setBlockTextureName(ReferenceSC.MODID + ":ores/zecha");
		setBlockName("oreZecha");
		setHardness(9f);
		setHarvestLevel("pickaxe", 3);
		setResistance(19f);
		setStepSound(soundTypeStone);
	}
	
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity){ return !(entity instanceof EntityDragon); }
	
	public String getRegistryName(){ return "zecha_ore"; }
	
}

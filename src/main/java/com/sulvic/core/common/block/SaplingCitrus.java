package com.sulvic.core.common.block;

import java.util.List;
import java.util.Random;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;
import com.sulvic.core.world.gen.SulvicTreeGen;

import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

@RegibaRegistry
@SuppressWarnings({"rawtypes", "unchecked"})
public class SaplingCitrus extends BlockSapling implements INamed{
	
	public SaplingCitrus(){
		super();
		setBlockName("saplingCitrus");
		setCreativeTab(FolkrumTabs.BLOCKS);
	}
	
	public IIcon getIcon(int metadata, int side){ return blockIcon; }
	
	public String getRegistryName(){ return "citrus_sapling"; }
	
	public void func_149878_d(World world, int x, int y, int z, Random random){ SulvicTreeGen.CITRUS_TREE.generate(world, random, x, y, z); }
	
	public void getSubBlocks(Item item, CreativeTabs tab, List list){ list.add(new ItemStack(item, 1, 0)); }
	
	public void registerBlockIcons(IIconRegister registry){ blockIcon = registry.registerIcon(ReferenceSC.MODID + ":citrus/sapling"); }
	
}

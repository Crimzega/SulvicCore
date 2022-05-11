package com.sulvic.core.common.block;

import java.util.List;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.item.block.ItemBlockGem;
import com.sulvic.core.lib.GemstoneData;
import com.sulvic.core.lib.GemstoneData.Type;
import com.sulvic.core.lib.IGemstone;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.IBlock;
import com.sulvic.core.lib.RegibaRegistry.INamed;
import com.sulvic.core.proxy.AlvontixClient;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

@RegibaRegistry
@SuppressWarnings({"rawtypes", "unchecked"})
public class BlockGem extends Block implements IBlock, INamed{
	
	@AlvontixClient
	private IIcon[] texture;
	
	public BlockGem(){
		super(Material.iron);
		setBlockName("gem");
		setCreativeTab(FolkrumTabs.BLOCKS);
		setHardness(3f);
		setHarvestLevel("pickaxe", 2);
		setResistance(5f);
		setStepSound(soundTypePiston);
	}
	
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ){ return true; }
	
	public Class<? extends ItemBlock> itemClass(){ return ItemBlockGem.class; }
	
	@AlvontixClient
	public IIcon getIcon(int side, int metadata){ return texture[metadata]; }
	
	public int damageDropped(int metadata){ return metadata; }
	
	public MapColor getMapColor(int metadata){ return GemstoneData.getMapColor(metadata); }
	
	public String getRegistryName(){ return "gem_ore"; }
	
	@AlvontixClient
	public void getSubBlocks(Item item, CreativeTabs tab, List list){ for(Type type: Type.values()) list.add(new ItemStack(item, 1, type.getMetadata())); }
	
	@AlvontixClient
	public void registerBlockIcons(IIconRegister registry){
		texture = new IIcon[GemstoneData.size()];
		for(IGemstone type: GemstoneData.getGems()) texture[type.getMetadata()] = registry.registerIcon(ReferenceSC.MODID + ":gems/" + type.getName());
	}
	
}

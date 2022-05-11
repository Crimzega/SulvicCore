package com.sulvic.core.common.block;

import java.util.List;
import java.util.Random;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.SulvicObjects;
import com.sulvic.core.common.item.block.ItemBlockGem;
import com.sulvic.core.lib.GemstoneData;
import com.sulvic.core.lib.GemstoneData.Type;
import com.sulvic.core.lib.IGemstone;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.IBlock;
import com.sulvic.core.lib.RegibaRegistry.INamed;
import com.sulvic.core.proxy.AlvontixClient;
import com.sulvic.util.SulvicMath;

import net.minecraft.block.Block;
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
public class OreGem extends Block implements IBlock, INamed{
	
	@AlvontixClient
	private IIcon[] texture;
	private boolean isNetherVariant;
	private Random rand = new Random();
	
	public OreGem(){
		super(Material.iron);
		setBlockName("oreGem");
		setCreativeTab(FolkrumTabs.BLOCKS);
		setHardness(3f);
		setHarvestLevel("pickaxe", 2);
		setResistance(5f);
		setStepSound(soundTypePiston);
	}
	
	public Class<? extends ItemBlock> itemClass(){ return ItemBlockGem.class; }
	
	@AlvontixClient
	public IIcon getIcon(int side, int metadata){ return texture[metadata]; }
	
	public int getExpDrop(IBlockAccess world, int metadata, int fortune){
		if(getItemDropped(metadata, rand, fortune) != Item.getItemFromBlock(this)) return SulvicMath.rangedInt(rand, 3, 7);
		return 0;
	}
	
	public int quantityDropped(Random random){ return isNetherVariant? 2: 1; }
	
	public int quantityDroppedWithBonus(int fortune, Random random){
		if(fortune > 0 && getItemDropped(0, rand, fortune) != Item.getItemFromBlock(this)){
			int amount = SulvicMath.maxInt(0, rand.nextInt(fortune + 2) - 1);
			return quantityDropped(random) * amount * 1;
		}
		return quantityDropped(random);
	}
	
	public OreGem asNetherVariant(){
		isNetherVariant = true;
		setBlockName("oreGem.nether");
		return this;
	}
	
	public int damageDropped(int metadata){ return metadata; }
	
	public Item getItemDropped(int metadata, Random random, int fortune){ return SulvicObjects.GEMS; }
	
	public String getRegistryName(){ return isNetherVariant? "nether_gem_block": "gem_block"; }
	
	@AlvontixClient
	public void getSubBlocks(Item item, CreativeTabs tab, List list){ for(Type type: Type.values()) list.add(new ItemStack(item, 1, type.getMetadata())); }
	
	@AlvontixClient
	public void registerBlockIcons(IIconRegister registry){
		texture = new IIcon[GemstoneData.size()];
		for(IGemstone type: GemstoneData.getGems()) texture[type.getMetadata()] = registry.registerIcon(ReferenceSC.MODID + ":" + (isNetherVariant? "nether": "") + "ores/" + type.getName());
	}
	
}

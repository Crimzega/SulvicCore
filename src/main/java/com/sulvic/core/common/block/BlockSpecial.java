package com.sulvic.core.common.block;

import java.util.List;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.common.item.block.ItemBlockSpecial;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.IBlock;
import com.sulvic.core.lib.RegibaRegistry.INamed;
import com.sulvic.core.proxy.AlvontixClient;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

@RegibaRegistry
@SuppressWarnings({"rawtypes", "unchecked"})
public class BlockSpecial extends Block implements IBlock, INamed{
	
	@AlvontixClient
	private IIcon[] texture;
	
	public BlockSpecial(){
		super(JemurinMaterial.SPECIAL_MATERIAL);
		setBlockName("special");
		setCreativeTab(FolkrumTabs.BLOCKS);
		setHardness(15f);
		setHarvestLevel("pickaxe", 3);
		setResistance(25f);
		setStepSound(soundTypePiston);
	}
	
	public Class<? extends ItemBlock> itemClass(){ return ItemBlockSpecial.class; }
	
	@AlvontixClient
	public IIcon getIcon(int side, int metadata){ return texture[metadata]; }
	
	public int damageDropped(int metadata){ return metadata; }
	
	public String getRegistryName(){ return "special_block"; }
	
	public void getSubBlocks(Item item, CreativeTabs tabs, List list){ for(int i = 0; i < 2; i++) list.add(new ItemStack(this, 1, i)); }
	
	@AlvontixClient
	public void registerBlockIcons(IIconRegister registry){
		texture = new IIcon[2];
		texture[0] = registry.registerIcon(ReferenceSC.MODID + ":special/dust");
		texture[1] = registry.registerIcon(ReferenceSC.MODID + ":special/metal");
	}
	
}

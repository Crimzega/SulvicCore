package com.sulvic.core.common.block;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;
import com.sulvic.core.proxy.AlvontixClient;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

@RegibaRegistry
public class BlockZecha extends Block implements INamed{
	
	@AlvontixClient
	private IIcon topIcon, bottomIcon;
	
	public BlockZecha(){
		super(JemurinMaterial.ZECHA_MATERIAL);
		setBlockName("zecha");
		setCreativeTab(FolkrumTabs.BLOCKS);
		setHardness(19f);
		setHarvestLevel("pickaxe", 3);
		setLightLevel(0.75f);
		setResistance(29f);
		setStepSound(soundTypeMetal);
	}
	
	@AlvontixClient
	public IIcon getIcon(int side, int metadata){ return side == 0? bottomIcon: side == 1? topIcon: blockIcon; }
	
	public String getRegistryName(){ return "zecha_block"; }
	
	@AlvontixClient
	public void registerBlockIcons(IIconRegister registry){
		blockIcon = registry.registerIcon(ReferenceSC.MODID + ":zecha/side");
		topIcon = registry.registerIcon(ReferenceSC.MODID + ":zecha/top");
		bottomIcon = registry.registerIcon(ReferenceSC.MODID + ":zecha/bottom");
	}
	
}

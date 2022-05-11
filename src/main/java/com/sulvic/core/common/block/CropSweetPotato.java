package com.sulvic.core.common.block;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.SulvicObjects;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;
import com.sulvic.core.proxy.AlvontixClient;

import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

@RegibaRegistry
public class CropSweetPotato extends BlockCrops implements INamed{
	
	@AlvontixClient
	private IIcon[] textures;
	
	public CropSweetPotato(){
		super();
		setBlockName("sweetPotato");
	}
	
	@AlvontixClient
	public IIcon getIcon(int side, int metadata){
		if(metadata < 7){
			if(metadata == 6) metadata = 5;
			return textures[metadata >> 1];
		}
		return textures[3];
	}
	
	protected Item func_149866_i(){ return SulvicObjects.SWEET_POTATO; }
	
	protected Item func_149865_P(){ return SulvicObjects.SWEET_POTATO; }
	
	public String getRegistryName(){ return "sweet_potatoes"; }
	
	@AlvontixClient
	public void registerBlockIcons(IIconRegister registry){
		textures = new IIcon[4];
		for(int i = 0; i < textures.length; i++) textures[i] = registry.registerIcon(ReferenceSC.MODID + ":crops/sweet_potato" + i);
	}
	
}

package com.sulvic.core.common.item;

import java.util.List;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.lib.GemstoneData;
import com.sulvic.core.lib.GemstoneData.Type;
import com.sulvic.core.lib.IGemstone;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;
import com.sulvic.core.proxy.AlvontixClient;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

@RegibaRegistry
@SuppressWarnings({"rawtypes", "unchecked"})
public class ItemGem extends Item implements INamed{
	
	@AlvontixClient
	private IIcon[] texture;
	
	public ItemGem(){
		setCreativeTab(FolkrumTabs.ITEMS);
		setHasSubtypes(true);
		setUnlocalizedName("gem");
	}
	
	public boolean isBeaconPayment(ItemStack stack){ return true; }
	
	public int getMetadata(int metadata){ return metadata; }
	
	@AlvontixClient
	public IIcon getIconFromDamage(int metadata){ return texture[metadata]; }
	
	public String getUnlocalizedName(ItemStack stack){
		int metadata = stack.getItemDamage();
		if(metadata < 0 || metadata >= GemstoneData.size()) metadata = 0;
		return getUnlocalizedName() + '.' + GemstoneData.byMetadata(metadata).getUnlocalName();
	}
	
	public String getRegistryName(){ return "gem"; }
	
	@AlvontixClient
	public void getSubItems(Item item, CreativeTabs tab, List list){ for(Type type: Type.values()) list.add(new ItemStack(item, 1, type.getMetadata())); }
	
	@AlvontixClient
	public void registerIcons(IIconRegister registry){
		texture = new IIcon[GemstoneData.size()];
		for(IGemstone type: GemstoneData.getGems()) texture[type.getMetadata()] = registry.registerIcon(ReferenceSC.MODID + ":gems/" + type.getName());
	}
	
}

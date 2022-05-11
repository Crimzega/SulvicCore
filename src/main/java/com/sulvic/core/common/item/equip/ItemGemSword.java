package com.sulvic.core.common.item.equip;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.lib.GemstoneData;
import com.sulvic.core.lib.IGemstone;
import com.sulvic.core.proxy.AlvontixClient;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;

public class ItemGemSword extends ItemSword{
	
	@AlvontixClient
	private IIcon hiltIcon;
	private IGemstone gemType;
	
	public ItemGemSword(IGemstone type){
		super(GemstoneData.getGemToolMaterial(type));
		setCreativeTab(FolkrumTabs.EQUIP);
		setUnlocalizedName(type.getUnlocalName() + "Sword");
		gemType = type;
	}
	
	@AlvontixClient
	public boolean requiresMultipleRenderPasses(){ return true; }
	
	public int getColorFromItemStack(ItemStack stack, int pass){ return pass == 1? GemstoneData.getGemColor(gemType): 0xFFFFFF; }
	
	@AlvontixClient
	public IIcon getIconFromDamageForRenderPass(int metadata, int pass){ return pass == 1? itemIcon: hiltIcon; }
	
	@AlvontixClient
	public void registerIcons(IIconRegister registry){
		itemIcon = registry.registerIcon(ReferenceSC.MODID + ":tools/colored/base_sword");
		hiltIcon = registry.registerIcon(ReferenceSC.MODID + ":tools/base/wood_sword");
	}
	
}

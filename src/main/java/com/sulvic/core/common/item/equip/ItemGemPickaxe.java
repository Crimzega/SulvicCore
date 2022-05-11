package com.sulvic.core.common.item.equip;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.lib.GemstoneData;
import com.sulvic.core.lib.IGemstone;
import com.sulvic.core.proxy.AlvontixClient;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemGemPickaxe extends ItemPickaxe{
	
	@AlvontixClient
	private IIcon hiltIcon;
	private IGemstone gemType;
	
	public ItemGemPickaxe(IGemstone type){
		super(GemstoneData.getGemToolMaterial(type));
		setCreativeTab(FolkrumTabs.TOOLS);
		setUnlocalizedName(type.getUnlocalName() + "Pickaxe");
		gemType = type;
	}
	
	@AlvontixClient
	public boolean requiresMultipleRenderPasses(){ return true; }
	
	public int getColorFromItemStack(ItemStack stack, int pass){ return pass == 1? GemstoneData.getGemColor(gemType): 0xFFFFFF; }
	
	@AlvontixClient
	public IIcon getIconFromDamageForRenderPass(int metadata, int pass){ return pass == 1? itemIcon: hiltIcon; }
	
	@AlvontixClient
	public void registerIcons(IIconRegister registry){
		itemIcon = registry.registerIcon(ReferenceSC.MODID + ":tools/colored/base_pickaxe");
		hiltIcon = registry.registerIcon(ReferenceSC.MODID + ":tools/base/wood_pickaxe");
	}
	
}

package com.sulvic.core.common.item.equip;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.handler.SulvicMasterHandler;
import com.sulvic.core.lib.GemstoneData;
import com.sulvic.core.lib.IGemstone;
import com.sulvic.core.proxy.AlvontixClient;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemGemHoe extends ItemHoe implements IFarmRange{
	
	@AlvontixClient
	private IIcon hiltIcon;
	private IGemstone gemType;
	
	public ItemGemHoe(IGemstone type){
		super(GemstoneData.getGemToolMaterial(type));
		setCreativeTab(FolkrumTabs.TOOLS);
		setUnlocalizedName(type.getUnlocalName() + "Hoe");
		gemType = type;
	}
	
	@AlvontixClient
	public boolean requiresMultipleRenderPasses(){ return true; }
	
	public int getColorFromItemStack(ItemStack stack, int pass){ return pass == 1? GemstoneData.getGemColor(gemType): 0xFFFFFF; }
	
	@AlvontixClient
	public IIcon getIconFromDamageForRenderPass(int metadata, int pass){ return pass == 1? itemIcon: hiltIcon; }
	
	public int maxRange(){ return 3; }
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		MovingObjectPosition movObjPos = Minecraft.getMinecraft().objectMouseOver;
		SulvicMasterHandler.makeFarlmand(world, movObjPos.blockX, movObjPos.blockY, movObjPos.blockZ, this, this);
		return stack;
	}
	
	@AlvontixClient
	public void registerIcons(IIconRegister registry){
		itemIcon = registry.registerIcon(ReferenceSC.MODID + ":tools/colored/base_hoe");
		hiltIcon = registry.registerIcon(ReferenceSC.MODID + ":tools/base/wood_hoe");
	}
	
}

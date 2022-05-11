package com.sulvic.core.common.item.equip;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.handler.SulvicMasterHandler;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

@RegibaRegistry
public class ItemSpecialHoe extends ItemHoe implements IFarmRange, INamed{
	
	public ItemSpecialHoe(){
		super(JemurinMaterial.SPECIAL_TOOL_MATERIAL);
		setCreativeTab(FolkrumTabs.TOOLS);
		setTextureName(ReferenceSC.MODID + ":tools/special_hoe");
		setUnlocalizedName("specialHoe");
	}
	
	public int maxRange(){ return 4; }
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		MovingObjectPosition movObjPos = Minecraft.getMinecraft().objectMouseOver;
		SulvicMasterHandler.makeFarlmand(world, movObjPos.blockX, movObjPos.blockY, movObjPos.blockZ, this, this);
		return stack;
	}
	
	public String getRegistryName(){ return "special_hoe"; }
	
}

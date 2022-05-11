package com.sulvic.core.handler;

import java.util.Set;

import com.google.common.collect.Sets;
import com.sulvic.core.SulvicCore;
import com.sulvic.core.common.SulvicObjects;
import com.sulvic.core.common.item.equip.IFarmRange;
import com.sulvic.core.proxy.AlvontixClient;
import com.sulvic.core.proxy.SulvicClient;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class SulvicMasterHandler{
	
	private static final Set<Block> PILE_DEFAULTS = Sets.newHashSet(Blocks.planks, Blocks.bookshelf, Blocks.quartz_block, SulvicObjects.CITRUS_PLANKS), PILE_CONFIG = Sets.newHashSet();
	public static final SulvicMasterHandler INSTANCE = new SulvicMasterHandler();
	private static boolean isFancy = Minecraft.isFancyGraphicsEnabled();
	
	public static boolean usingFancyGraphics(){ return isFancy; }
	
	public static boolean isPileOnTopOf(Block block){ return PILE_DEFAULTS.contains(block) || PILE_CONFIG.contains(block); }
	
	public static void getConfigPileBlocks(){
		for(String blockName: SulvicCore.getConfig().getPileBlocks()){
			String[] split = blockName.split(":");
			Block block = GameRegistry.findBlock(split[0], split[1]);
			if(block != null) PILE_CONFIG.add(block);
		}
	}
	
	public static void makeFarlmand(World world, int x, int y, int z, ItemHoe hoe, IFarmRange range){
		int size = range.maxRange();
		for(int i = -size; i < size; i++) for(int j = -size; j < size; j++){
			Block block = world.getBlock(x - i, y, z - j);
			if(block == Blocks.dirt || block == Blocks.grass) world.setBlock(x - i, y, z - j, Blocks.farmland);
		}
	}
	
	@SubscribeEvent
	public void onPickedUp(ItemPickupEvent evt){
		EntityPlayer player = evt.player;
		ItemStack stack = evt.pickedUp.getEntityItem();
		Item item = stack.getItem();
		if(item == Item.getItemFromBlock(SulvicObjects.CITRUS_LOG)) player.triggerAchievement(AchievementList.mineWood);
	}
	
	@AlvontixClient
	@SubscribeEvent
	public void onRender(RenderTickEvent evt){
		if(isFancy != Minecraft.isFancyGraphicsEnabled()) ((SulvicClient)SulvicCore.proxy).setFancyRender(isFancy = Minecraft.isFancyGraphicsEnabled());
	}
	
	@SubscribeEvent
	public void onUseHoe(UseHoeEvent evt){
		World world = evt.world;
		ItemStack stack = evt.current;
		int posX = evt.x, posY = evt.y, posZ = evt.z;
		if(stack != null){
			Item item = stack.getItem();
			if(item instanceof ItemHoe && !(item instanceof IFarmRange)){
				ItemHoe hoe = (ItemHoe)item;
				makeFarlmand(world, posX, posY, posZ, hoe, EnumFarmRange.byMaterialName(hoe.getToolMaterialName()));
			}
		}
	}
	
	@SubscribeEvent
	public void onInteract(PlayerInteractEvent evt){
		EntityPlayer player = evt.entityPlayer;
		World world = player.worldObj;
		ItemStack stack = player.getHeldItem();
		if(stack != null){
			Item item = stack.getItem();
			switch(evt.action){
				case RIGHT_CLICK_AIR:
				break;
				case RIGHT_CLICK_BLOCK:
					if(item == Items.sugar){
						MovingObjectPosition movObjPos = Minecraft.getMinecraft().objectMouseOver;
						int posX = movObjPos.blockX, posY = movObjPos.blockY, posZ = movObjPos.blockZ;
						if(isPileOnTopOf(world.getBlock(posX, posY, posZ)) && world.isAirBlock(posX, posY + 1, posZ) && !world.isRemote){
							world.setBlock(posX, posY + 1, posZ, SulvicObjects.SUGAR_PILE);
							if(!player.capabilities.isCreativeMode) stack.stackSize--;
						}
					}
				break;
				default:
				break;
			}
		}
	}
	
	private static enum EnumFarmRange implements IFarmRange{
		
		WOOD,
		STONE,
		IRON,
		DIAMOND,
		GOLD;
		
		public static EnumFarmRange byMaterialName(String matName){
			switch(matName){
				case "WOOD":
					return WOOD;
				case "STONE":
					return STONE;
				case "IRON":
					return IRON;
				case "DIAMOND":
					return DIAMOND;
				case "GOLD":
					return GOLD;
				default:
					return WOOD;
			}
		}
		
		public int maxRange(){
			switch(this){
				case STONE:
					return 1;
				case IRON:
					return 2;
				case DIAMOND:
					return 3;
				default:
					return 0;
			}
		}
		
	}
	
}

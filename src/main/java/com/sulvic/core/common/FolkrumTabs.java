package com.sulvic.core.common;

import com.sulvic.core.lib.GemstoneData.Type;
import com.sulvic.core.proxy.AlvontixClient;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FolkrumTabs{
	
	public static final CustomTab BLOCKS = new CustomTab("blocks"){
		
		public Item getTabIconItem(){ return Item.getItemFromBlock(SulvicObjects.GEM_BLOCKS); }
		
		public ItemStack getIconItemStack(){ return new ItemStack(getTabIconItem(), 1, Type.ENSTATITE.getMetadata()); }
		
	}, ITEMS = new CustomTab("items"){
		
		public Item getTabIconItem(){ return SulvicObjects.GEMS; }
		
		public ItemStack getIconItemStack(){ return new ItemStack(getTabIconItem(), 1, Type.PERIDOT.getMetadata()); }
		
	}, EQUIP = new CustomTab("equip"){
		
		public Item getTabIconItem(){ return SulvicObjects.getGemSword(Type.FIRE_AGATE); }
		
	}, TOOLS = new CustomTab("tools"){
		
		public Item getTabIconItem(){ return SulvicObjects.getGemPickaxe(Type.CASSITERITE); }
		
	}, FOOD = new CustomTab("food"){
		
		public Item getTabIconItem(){ return SulvicObjects.ENERGY_BAR; }
		
	};
	
	public static boolean inRightTab(CreativeTabs currentTab, CreativeTabs itemTab){ return currentTab == itemTab || currentTab == CreativeTabs.tabAllSearch; }
	
	public static boolean inRightTab(CreativeTabs currentTab, Block block){ return inRightTab(currentTab, block.getCreativeTabToDisplayOn()); }
	
	public static boolean inRightTab(CreativeTabs currentTab, Item item){ return inRightTab(currentTab, item.getCreativeTab()); }
	
	private static abstract class CustomTab extends CreativeTabs{
		
		public CustomTab(String label){ super(label); }
		
		@AlvontixClient
		public String getTranslatedTabLabel(){ return "modGroup." + getTabLabel(); }
		
	}
	
}

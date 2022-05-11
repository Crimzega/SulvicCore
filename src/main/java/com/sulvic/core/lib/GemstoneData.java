package com.sulvic.core.lib;

import static net.minecraft.block.material.MapColor.adobeColor;
import static net.minecraft.block.material.MapColor.blackColor;
import static net.minecraft.block.material.MapColor.goldColor;
import static net.minecraft.block.material.MapColor.iceColor;
import static net.minecraft.block.material.MapColor.lightBlueColor;
import static net.minecraft.block.material.MapColor.limeColor;
import static net.minecraft.block.material.MapColor.obsidianColor;
import static net.minecraft.block.material.MapColor.pinkColor;
import static net.minecraft.block.material.MapColor.purpleColor;
import static net.minecraft.block.material.MapColor.tntColor;
import static net.minecraft.block.material.MapColor.yellowColor;

import java.util.List;

import com.google.common.collect.Lists;
import com.sulvic.core.SulvicCore;
import com.sulvic.core.common.SulvicObjects;

import net.minecraft.block.material.MapColor;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class GemstoneData{
	
	private static final List<int[]> ARMOR_REDUCTIONS = Lists.newArrayList(new int[]{2, 7, 5, 2}, new int[]{4, 9, 7, 4}, new int[]{3, 8, 6, 3}, new int[]{3, 8, 6, 3}, new int[]{2, 7, 5, 2},
		new int[]{3, 8, 6, 3}, new int[]{3, 8, 6, 3}, new int[]{4, 9, 7, 4}, new int[]{3, 8, 6, 3}, new int[]{4, 9, 7, 4}, new int[]{3, 8, 6, 3}, new int[]{4, 9, 7, 4}, new int[]{2, 7, 5, 2},
		new int[]{3, 8, 6, 3}, new int[]{2, 7, 5, 2});
	private static final List<Float> TOOL_DAMAGES = Lists.newArrayList(4f, 5f, 2f, 4f, 2f, 3f, 2f, 5f, 4f, 2f, 3f, 4f, 5f, 2f, 4f),
		TOOL_EFFICIENCIES = Lists.newArrayList(9f, 10f, 7f, 9f, 7f, 8f, 7f, 10f, 9f, 7f, 8f, 9f, 10f, 7f, 9f);
	private static final List<ArmorMaterial> ARMOR_MATERIALS = Lists.newArrayList();
	private static final List<Float> FURNACE_XPS = Lists.newArrayList(0.65f, 0.86f, 0.63f, 0.71f, 0.7f, 0.93f, 0.79f, 0.76f, 0.79f, 0.74f, 0.66f, 0.76f, 0.87f, 0.71f, 0.8f, 0.62f);
	private static final List<Integer> GEMSTONE_COLORS = Lists.newArrayList(0xDD2F46, 0xFF40FF, 0x7E3E7E, 0x151515, 0xE7B600, 0xFFFF61, 0x8EC2FF, 0xFF9200, 0xFF8499, 0x00FF21, 0x3BC9D6,
		0xD85900, 0x3D1386, 0x4F2454, 0x343434), TOOL_MAX_USES = Lists.newArrayList(1643, 1758, 1497, 1643, 1497, 1561, 1497, 1758, 1643, 1497, 1561, 1643, 1758, 1497, 1643);
	private static final List<ToolMaterial> TOOL_MATERIALS = Lists.newArrayList();
	private static final List<IGemstone> GEMSTONES = Lists.newArrayList();
	private static final List<String> MATERIAL_NAMES = Lists.newArrayList();
	private static final List<MapColor> MAP_COLORS = Lists.newArrayList(tntColor, pinkColor, purpleColor, blackColor, goldColor, yellowColor, iceColor, yellowColor, pinkColor, limeColor,
		lightBlueColor, adobeColor, purpleColor, purpleColor, obsidianColor);
	
	public static ArmorMaterial getGemArmorMaterial(IGemstone type){ return ARMOR_MATERIALS.get(type.getMetadata()); }
	
	public static float getGemXP(IGemstone gem){ return FURNACE_XPS.get(gem.getMetadata()); }
	
	public static IGemstone createGemData(String enumName, final String name, final String unlocal, int color, int uses, float damage, float efficiency, int[] reductionAmounts, float xp,
		MapColor mapColor){
		enumName = enumName.toUpperCase();
		final int metadata = size();
		GEMSTONES.add(new IGemstone(){
			
			public int getMetadata(){ return metadata; }
			
			public String getName(){ return name; }
			
			public String getUnlocalName(){ return unlocal; }
			
		});
		GEMSTONE_COLORS.add(color);
		FURNACE_XPS.add(xp);
		MAP_COLORS.add(mapColor);
		ToolMaterial toolMat = EnumHelper.addToolMaterial(enumName, 3, uses, efficiency, damage, 10);
		toolMat.setRepairItem(new ItemStack(SulvicObjects.GEMS, 1, metadata));
		TOOL_MATERIALS.add(toolMat);
		ArmorMaterial armorMat = EnumHelper.addArmorMaterial(enumName, 33, reductionAmounts, 10);
		armorMat.customCraftingMaterial = SulvicObjects.GEMS;
		ARMOR_MATERIALS.add(armorMat);
		return GEMSTONES.get(metadata);
	}
	
	public static IGemstone byMetadata(int metadata){
		for(IGemstone type: GEMSTONES) if(type.getMetadata() == metadata) return type;
		return null;
	}
	
	public static int getGemColor(IGemstone gem){ return GEMSTONE_COLORS.get(gem.getMetadata()); }
	
	public static int size(){ return GEMSTONES.size(); }
	
	public static List<IGemstone> getGems(){ return GEMSTONES; }
	
	public static MapColor getMapColor(int metadata){ return MAP_COLORS.get(metadata); }
	
	public static ToolMaterial getGemToolMaterial(IGemstone type){ return TOOL_MATERIALS.get(type.getMetadata()); }
	
	public static void build(){
		SulvicCore.getLogger().info("Building up all gemstone data well before any blocks or items.");
		for(Type type: Type.values()){
			GEMSTONES.add(type);
			MATERIAL_NAMES.add(type.name());
		}
		for(IGemstone gem: GEMSTONES){
			int metadata = gem.getMetadata();
			ARMOR_MATERIALS.add(EnumHelper.addArmorMaterial(MATERIAL_NAMES.get(metadata), 33, ARMOR_REDUCTIONS.get(metadata), 10));
			TOOL_MATERIALS.add(EnumHelper.addToolMaterial(MATERIAL_NAMES.get(metadata), 3, TOOL_MAX_USES.get(metadata), TOOL_EFFICIENCIES.get(metadata), TOOL_DAMAGES.get(metadata), 10));
		}
	}
	
	public static enum Type implements IGemstone{
		
		RUBY,
		PINK_PANTHER,
		SAPPHIRE,
		CASSITERITE,
		ENSTATITE,
		MOONSTONE,
		AQUAMARINE,
		CITRINE,
		TOURMALINE,
		PERIDOT,
		BERYL,
		FIRE_AGATE,
		DRUZY,
		AMETRINE,
		ONYX;
		
		public int getMetadata(){ return ordinal(); }
		
		public String getName(){ return name().toLowerCase(); }
		
		public String getUnlocalName(){
			switch(this){
				case PINK_PANTHER:
					return "pinkPanther";
				case FIRE_AGATE:
					return "fireAgate";
				default:
					return getName();
			}
		}
		
	}
	
}

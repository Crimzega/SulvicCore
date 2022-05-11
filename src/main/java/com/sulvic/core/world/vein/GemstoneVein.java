package com.sulvic.core.world.vein;

import static com.sulvic.core.common.SulvicObjects.FLATLANDS;
import static com.sulvic.core.common.SulvicObjects.GEM_ORES;
import static com.sulvic.core.world.vein.core.VeinData.createData;
import static net.minecraft.world.biome.BiomeGenBase.beach;
import static net.minecraft.world.biome.BiomeGenBase.birchForestHills;
import static net.minecraft.world.biome.BiomeGenBase.coldBeach;
import static net.minecraft.world.biome.BiomeGenBase.coldTaigaHills;
import static net.minecraft.world.biome.BiomeGenBase.deepOcean;
import static net.minecraft.world.biome.BiomeGenBase.desert;
import static net.minecraft.world.biome.BiomeGenBase.desertHills;
import static net.minecraft.world.biome.BiomeGenBase.extremeHills;
import static net.minecraft.world.biome.BiomeGenBase.forest;
import static net.minecraft.world.biome.BiomeGenBase.forestHills;
import static net.minecraft.world.biome.BiomeGenBase.frozenOcean;
import static net.minecraft.world.biome.BiomeGenBase.frozenRiver;
import static net.minecraft.world.biome.BiomeGenBase.jungle;
import static net.minecraft.world.biome.BiomeGenBase.jungleHills;
import static net.minecraft.world.biome.BiomeGenBase.mesa;
import static net.minecraft.world.biome.BiomeGenBase.mesaPlateau;
import static net.minecraft.world.biome.BiomeGenBase.mesaPlateau_F;
import static net.minecraft.world.biome.BiomeGenBase.mushroomIsland;
import static net.minecraft.world.biome.BiomeGenBase.mushroomIslandShore;
import static net.minecraft.world.biome.BiomeGenBase.ocean;
import static net.minecraft.world.biome.BiomeGenBase.plains;
import static net.minecraft.world.biome.BiomeGenBase.river;
import static net.minecraft.world.biome.BiomeGenBase.savanna;
import static net.minecraft.world.biome.BiomeGenBase.savannaPlateau;
import static net.minecraft.world.biome.BiomeGenBase.stoneBeach;
import static net.minecraft.world.biome.BiomeGenBase.swampland;
import static net.minecraft.world.biome.BiomeGenBase.taiga;
import static net.minecraft.world.biome.BiomeGenBase.taigaHills;

import java.util.List;

import com.google.common.collect.Lists;
import com.sulvic.core.lib.GemstoneData.Type;
import com.sulvic.core.lib.IGemstone;
import com.sulvic.core.world.vein.core.IBiomeList;
import com.sulvic.core.world.vein.core.IVeinMeta;
import com.sulvic.core.world.vein.core.VeinData;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class GemstoneVein implements IVeinMeta, IBiomeList{
	
	private static List<GemstoneVein> gemstoneVeins = Lists.newArrayList();
	private List<BiomeGenBase> allowedBiomes;
	private IGemstone veinType;
	private VeinData veinData;
	
	private GemstoneVein(IGemstone gem, VeinData data, BiomeGenBase... biomes){
		veinType = gem;
		veinData = data;
		if(biomes.length > 0) allowedBiomes = Lists.newArrayList(biomes);
		if(!gemstoneVeins.contains(this)) gemstoneVeins.add(this);
	}
	
	public static void createVein(IGemstone gem, int y, int y1, int min, int max, int size, BiomeGenBase... biomes){
		gemstoneVeins.add(new GemstoneVein(gem, createData(y, y1, min, max, size), biomes));
	}
	
	public static void init(){
		gemstoneVeins.add(new GemstoneVein(Type.RUBY, createData(4, 12, 2, 8, 5)));
		gemstoneVeins.add(new GemstoneVein(Type.PINK_PANTHER, createData(8, 20, 3, 6, 6), plains, desert, desertHills, extremeHills, jungle));
		gemstoneVeins.add(new GemstoneVein(Type.SAPPHIRE, createData(4, 12, 2, 5, 2), forest, taiga, swampland, stoneBeach));
		gemstoneVeins.add(new GemstoneVein(Type.CASSITERITE, createData(6, 17, 6, 9, 3)));
		gemstoneVeins.add(new GemstoneVein(Type.ENSTATITE, createData(4, 12, 4, 9, 4), ocean, river, frozenOcean, frozenRiver, deepOcean, mesa));
		gemstoneVeins.add(new GemstoneVein(Type.MOONSTONE, createData(6, 16, 2, 5, 6)));
		gemstoneVeins.add(new GemstoneVein(Type.AQUAMARINE, createData(4, 12, 2, 5, 2), plains, beach, stoneBeach, coldBeach, FLATLANDS));
		gemstoneVeins.add(new GemstoneVein(Type.CITRINE, createData(6, 14, 3, 9, 5)));
		gemstoneVeins.add(new GemstoneVein(Type.TOURMALINE, createData(4, 12, 2, 5, 2), extremeHills, desertHills, forestHills, taigaHills, jungleHills, birchForestHills, coldTaigaHills));
		gemstoneVeins.add(new GemstoneVein(Type.PERIDOT, createData(5, 14, 4, 6, 2), desert, beach, desertHills, savanna, savannaPlateau));
		gemstoneVeins.add(new GemstoneVein(Type.BERYL, createData(7, 12, 2, 10, 3)));
		gemstoneVeins.add(new GemstoneVein(Type.FIRE_AGATE, createData(8, 20, 2, 8, 2), desert, desertHills));
		gemstoneVeins.add(new GemstoneVein(Type.DRUZY, createData(4, 18, 4, 10, 1), mushroomIsland, mushroomIslandShore));
		gemstoneVeins.add(new GemstoneVein(Type.AMETRINE, createData(6, 12, 4, 8, 2)));
		gemstoneVeins.add(new GemstoneVein(Type.ONYX, createData(4, 11, 5, 11, 4), mesa, mesaPlateau, mesaPlateau_F));
	}
	
	public static List<GemstoneVein> getVeins(){ return gemstoneVeins; }
	
	public List<BiomeGenBase> getAllowedBiomes(){ return allowedBiomes; }
	
	public int getMetadata(){ return veinType.getMetadata(); }
	
	public Block getOre(){ return GEM_ORES; }
	
	public VeinData getVeinData(){ return veinData; }
	
}

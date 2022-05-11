package com.sulvic.core.world.gen;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sulvic.core.common.SulvicObjects;
import com.sulvic.core.world.vein.GemstoneVein;
import com.sulvic.core.world.vein.core.IBiomeList;
import com.sulvic.core.world.vein.core.IDimension;
import com.sulvic.core.world.vein.core.IVein;
import com.sulvic.core.world.vein.core.IVeinMeta;
import com.sulvic.core.world.vein.core.VeinData;
import com.sulvic.util.SulvicMath;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldVeinGen implements IWorldGenerator{
	
	private static final Map<Integer, List<IVein>> ADDITIONAL_VEINS = Maps.newHashMap();
	private static final Map<Integer, Boolean> FULL_RANGES = Maps.newHashMap();
	private static final WorldVeinGen INSTANCE = new WorldVeinGen();
	
	private WorldVeinGen(){}
	
	public static void addGeneratableVein(int dimId, IVein vein){
		if(!ADDITIONAL_VEINS.containsKey(dimId)) ADDITIONAL_VEINS.put(dimId, Lists.<IVein>newArrayList());
		if(!ADDITIONAL_VEINS.get(dimId).contains(vein)) ADDITIONAL_VEINS.get(dimId).add(vein);
	}
	
	public static void setFullRangeDimension(int dimId, boolean fullRange){ FULL_RANGES.put(dimId, fullRange); }
	
	public static WorldVeinGen instance(){ return INSTANCE; }
	
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider gen, IChunkProvider provider){
		switch(world.provider.dimensionId){
			case -1:
				generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
			case 0:
				generateOverworld(world, random, chunkX * 16, chunkZ * 16);
			break;
			case 1:
				generateEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
			default:
				generateUnknownDim(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}
	
	private void generateEndVein(World world, Random random, int startX, int startZ, IVein vein){
		VeinData data = vein.getVeinData();
		Block block = vein.getOre();
		int veinSize = data.getVeinSize(random);
		List<BiomeGenBase> biomes = Lists.newArrayList();
		if(vein instanceof IBiomeList) biomes = ((IBiomeList)vein).getAllowedBiomes();
		generateVein(world, random, startX, startZ, vein, true, biomes,
			vein instanceof IVeinMeta? new EndGenMinable(block, ((IVeinMeta)vein).getMetadata(), veinSize, Blocks.end_stone): new EndGenMinable(block, veinSize));
	}
	
	private void generateOverworldVein(World world, Random random, int startX, int startZ, IVein vein){
		VeinData data = vein.getVeinData();
		Block block = vein.getOre();
		int veinSize = data.getVeinSize(random);
		List<BiomeGenBase> biomes = Lists.newArrayList();
		if(vein instanceof IBiomeList) biomes = ((IBiomeList)vein).getAllowedBiomes();
		generateVein(world, random, startX, startZ, vein, false, biomes,
			vein instanceof IVeinMeta? new WorldGenMinable(block, ((IVeinMeta)vein).getMetadata(), veinSize, Blocks.stone): new WorldGenMinable(block, veinSize));
	}
	
	private void generateNetherVein(World world, Random random, int startX, int startZ, IVein vein){
		VeinData data = vein.getVeinData();
		Block block = vein.getOre();
		int veinSize = data.getVeinSize(random);
		List<BiomeGenBase> biomes = null;
		if(vein instanceof IBiomeList) biomes = ((IBiomeList)vein).getAllowedBiomes();
		generateVein(world, random, startX, startZ, vein, true, biomes,
			vein instanceof IVeinMeta? new NetherGenMinable(block, ((IVeinMeta)vein).getMetadata(), veinSize, Blocks.netherrack): new NetherGenMinable(block, veinSize));
	}
	
	private void generateUnknownDimVein(World world, Random random, int startX, int startZ, IVein vein){
		VeinData data = vein.getVeinData();
		Block block = vein.getOre(), stone = Blocks.stone;
		if(vein instanceof IDimension) stone = ((IDimension)vein).getStoneBlock();
		int veinSize = data.getVeinSize(random);
		List<BiomeGenBase> biomes = Lists.newArrayList();
		if(vein instanceof IBiomeList) biomes = ((IBiomeList)vein).getAllowedBiomes();
		generateVein(world, random, startX, startZ, vein, FULL_RANGES.get(world.provider.dimensionId), biomes,
			vein instanceof IVeinMeta? new WorldGenMinable(block, ((IVeinMeta)vein).getMetadata(), veinSize, stone): new WorldGenMinable(block, veinSize, stone));
	}
	
	private void generateVein(World world, Random random, int startX, int startZ, IVein vein, boolean fullRange, List<BiomeGenBase> biomes, WorldGenerator generator){
		VeinData data = vein.getVeinData();
		if(fullRange) data = data.fullRange();
		for(int i = 0; i < data.getVeinChance(); i++){
			int posX = SulvicMath.rangedInt(random, startX, startX + 16), posY = data.getPosY(random), posZ = SulvicMath.rangedInt(startZ, startZ + 16);
			if(biomes == null || biomes.size() > 0 && biomes.contains(world.getBiomeGenForCoords(posX, posZ))) generator.generate(world, random, posX, posY, posZ);
		}
	}
	
	private void generateEnd(World world, Random random, int startX, int startZ){
		List<IVein> veins = ADDITIONAL_VEINS.get(1);
		if(veins != null) for(IVein vein: veins) if(vein != null) generateEndVein(world, random, startX, startZ, vein);
	}
	
	private void generateNether(World world, Random random, int startX, int startZ){
		List<IVein> veins = ADDITIONAL_VEINS.get(-1);
		generateNetherVein(world, random, startX, startZ, SulvicObjects.SPECIAL_ORE);
		if(veins != null) for(IVein vein: veins) if(vein != null) generateNetherVein(world, random, startX, startZ, vein);
	}
	
	private void generateOverworld(World world, Random random, int startX, int startZ){
		for(GemstoneVein vein: GemstoneVein.getVeins()) generateOverworldVein(world, random, startX, startZ, vein);
		List<IVein> veins = ADDITIONAL_VEINS.get(0);
		if(veins != null) for(IVein vein: veins) if(vein != null) generateOverworldVein(world, random, startX, startZ, vein);
	}
	
	private void generateUnknownDim(World world, Random random, int startX, int startZ){
		List<IVein> veins = ADDITIONAL_VEINS.get(world.provider.dimensionId);
		if(veins != null) for(IVein vein: veins) if(vein != null) generateUnknownDimVein(world, random, startX, startZ, vein);
	}
	
}

package com.sulvic.core.world.gen;

import java.util.*;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sulvic.core.world.gen.tree.CitrusTreeGen;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class SulvicTreeGen implements IWorldGenerator{
	
	public static final CitrusTreeGen CITRUS_TREE = new CitrusTreeGen(true);
	private static List<TreeData> treeDataList = Lists.newArrayList();
	
	public static TreeData createTreeData(WorldGenAbstractTree treeGen){ return new TreeData(treeGen); }
	
	public static void addTreeData(TreeData data){ treeDataList.add(data); }
	
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){}
	
	public static class TreeData{
		
		private WorldGenAbstractTree theGenerator;
		private Map<BiomeGenBase, Double> biomeWeight = Maps.newHashMap();
		
		private TreeData(WorldGenAbstractTree treeGen){ theGenerator = treeGen; }
		
		public TreeData setBiomeWeight(BiomeGenBase biome, double weight){
			biomeWeight.put(biome, weight);
			return this;
		}
		
		public boolean shouldGenerate(BiomeGenBase biome){ return biomeWeight.isEmpty() || biomeWeight.containsKey(biome); }
		
		public boolean generate(World world, Random random, int x, int y, int z){ return theGenerator.generate(world, random, x, y, z); }
		
	}
	
}

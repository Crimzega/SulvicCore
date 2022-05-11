package com.sulvic.core.world.biome;

import java.util.Random;

import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.BiomeData;
import com.sulvic.core.world.gen.SulvicTreeGen;

import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

@RegibaRegistry
@BiomeData(value = BiomeType.WARM, weight = 6, types = {Type.LUSH, Type.PLAINS, Type.SPARSE})
@SuppressWarnings({"unchecked"})
public class BiomeCitrusGrove extends SulvicBiome{
	
	public BiomeCitrusGrove(){
		super();
		setBiomeName("Citrus Grove");
		setHeight(new Height(0.24f, 0.25f));
		setColor(0xAA7F47);
		setTemperatureRainfall(0.24f, 0.27f);
		theBiomeDecorator.treesPerChunk = 2;
	}
	
	public WorldGenAbstractTree func_150567_a(Random rand){ return SulvicTreeGen.CITRUS_TREE; }
	
	protected void addCreatures(){ spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 2, 1, 4)); }
	
}

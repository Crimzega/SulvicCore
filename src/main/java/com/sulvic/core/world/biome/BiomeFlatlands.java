package com.sulvic.core.world.biome;

import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.BiomeData;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

@RegibaRegistry
@BiomeData(value = BiomeType.WARM, weight = 10, spawnHere = true, types = {Type.LUSH, Type.PLAINS, Type.WET})
@SuppressWarnings({"unchecked"})
public class BiomeFlatlands extends SulvicBiome{
	
	public BiomeFlatlands(){
		super();
		setBiomeName("Flatlands");
		setColor(0x8db360);
		setHeight(new Height(0.25f, 0.27f));
		setTemperatureRainfall(0.25f, 0.3f);
		theBiomeDecorator.treesPerChunk = 0;
		theBiomeDecorator.flowersPerChunk = 4;
		theBiomeDecorator.grassPerChunk = 9;
	}
	
	protected void addCreatures(){
		spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 20, 3, 8));
		spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 15, 4, 9));
		spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 10, 7, 10));
		spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 10, 3, 5));
		spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 20, 4, 7));
		spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 5, 2, 5));
	}
	
}

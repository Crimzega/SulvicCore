package com.sulvic.core.world.biome;

import com.sulvic.core.SulvicCore;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.biome.BiomeGenBase;

@SuppressWarnings({"unchecked"})
public abstract class SulvicBiome extends BiomeGenBase{
	
	private static int currentBiomeId = SulvicCore.getConfig().getBiomeId();
	
	public SulvicBiome(){
		super(currentBiomeId);
		alterCreatureList();
		currentBiomeId++;
	}
	
	public SulvicBiome(int id, boolean register){
		super(id, register);
		alterCreatureList();
	}
	
	private void alterCreatureList(){
		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		addCreatures();
	}
	
	protected abstract void addCreatures();
	
	protected void addDefaultCreatures(){
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySheep.class, 12, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityPig.class, 10, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityChicken.class, 10, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityCow.class, 8, 4, 4));
	}
	
	protected void addDefaultMonsters(){
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySpider.class, 100, 4, 4));
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityZombie.class, 100, 4, 4));
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityCreeper.class, 100, 4, 4));
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySlime.class, 100, 4, 4));
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEnderman.class, 10, 1, 4));
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityWitch.class, 5, 1, 1));
	}
	
	protected void addDefaultCaveCreatures(){
		spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityBat.class, 10, 8, 8));
	}
	
	protected void addDefaultWaterCreatures(){
		spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySquid.class, 10, 4, 4));
	}
	
}

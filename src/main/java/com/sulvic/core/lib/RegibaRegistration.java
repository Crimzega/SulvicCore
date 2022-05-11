package com.sulvic.core.lib;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.lang.reflect.Field;

import com.sulvic.core.RegistryList;
import com.sulvic.core.RegistryList.ObjectEntry;
import com.sulvic.core.SulvicCore;
import com.sulvic.core.lib.RegibaRegistry.*;

import cpw.mods.fml.common.registry.*;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.item.*;
import net.minecraft.util.StringUtils;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.*;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

@SuppressWarnings({"unused"})
public class RegibaRegistration{
	
	private static boolean isRegisterable(Class<?> aClass){ return aClass.isAnnotationPresent(RegibaRegistry.class); }
	
	private static boolean isBiomeRegisterable(BiomeGenBase biome){ return isRegisterable(biome.getClass()) && biome.getClass().isAnnotationPresent(BiomeData.class); }
	
	private static boolean isBlockRegisterable(Block block){ return isRegisterable(block.getClass()) && block instanceof INamed; }
	
	private static boolean isEntityRegisterable(Class<? extends Entity> entityClass){ return isRegisterable(entityClass) && entityClass.isAnnotationPresent(EntityData.class); }
	
	private static boolean isEntitySpawnable(Class<? extends Entity> entityClass){
		return entityClass.isAnnotationPresent(EntitySpawn.class) && entityClass.isAssignableFrom(EntityLiving.class);
	}
	
	private static boolean isItemRegisterable(Item item){ return isRegisterable(item.getClass()) && item instanceof INamed; }
	
	private static boolean isListRegisterable(RegistryList<?> regList){
		return isRegisterable(regList.getClass()) && (regList.objectsAreOf(Block.class) || regList.objectsAreOf(Item.class));
	}
	
	public static boolean isRegistered(Block block){ return !StringUtils.isNullOrEmpty(GameData.getBlockRegistry().getNameForObject(block)); }
	
	public static boolean isRegistered(Item item){ return !StringUtils.isNullOrEmpty(GameData.getItemRegistry().getNameForObject(item)); }
	
	public static void registerBiome(BiomeGenBase biome){
		if(isBiomeRegisterable(biome)){
			BiomeData data = biome.getClass().getAnnotation(BiomeData.class);
			boolean canSpawn = data.spawnHere();
			BiomeManager.addBiome(data.value(), new BiomeEntry(biome, data.weight()));
			if(canSpawn) BiomeManager.addSpawnBiome(biome);
			if(data.villages()) BiomeManager.addVillageBiome(biome, canSpawn);
			if(data.strongholds()) BiomeManager.addStrongholdBiome(biome);
			BiomeDictionary.registerBiomeType(biome, data.types());
		}
	}
	
	public static void registerBlock(Block block){
		if(isBlockRegisterable(block)){
			String regName = ((INamed)block).getRegistryName();
			if(!(block instanceof IBlock)) GameRegistry.registerBlock(block, regName);
			else{
				Class<? extends ItemBlock> itemBlockClass = ((IBlock)block).itemClass();
				if(!(block instanceof IItemArgs)) GameRegistry.registerBlock(block, itemBlockClass, regName);
				else GameRegistry.registerBlock(block, itemBlockClass, regName, ((IItemArgs)block).ctorArgs());
			}
		}
	}
	
	public static void registerBlockList(RegistryList<? extends Block> blockList){
		if(isListRegisterable(blockList)) for(ObjectEntry<? extends Block> entry: blockList){
			Block block = entry.getObject();
			String regName = entry.getRegistryName();
			if(!(block instanceof IBlock)) GameRegistry.registerBlock(block, regName);
			else{
				Class<? extends ItemBlock> itemBlockClass = ((IBlock)block).itemClass();
				if(!(block instanceof IItemArgs)) GameRegistry.registerBlock(block, itemBlockClass, regName);
				else GameRegistry.registerBlock(block, itemBlockClass, regName, ((IItemArgs)block).ctorArgs());
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void registerEntity(Class<? extends Entity> entityClass, Object modInstance){
		if(isEntityRegisterable(entityClass)){
			int randomId = EntityRegistry.findGlobalUniqueEntityId();
			EntityData entityData = entityClass.getAnnotation(EntityData.class);
			String name = entityData.name();
			EntityRegistry.registerGlobalEntityID(entityClass, name, randomId);
			EntityRegistry.registerModEntity(entityClass, name, randomId, modInstance, entityData.trackRange(), entityData.updateFreq(), entityData.sendsVelUpdate());
			if(entityClass.isAnnotationPresent(EntitySpawn.class)){
				EntitySpawn spawn = entityClass.getAnnotation(EntitySpawn.class);
				EntityRegistry.addSpawn((Class<? extends EntityLiving>)entityClass, spawn.weight(), spawn.min(), spawn.max(), spawn.creatureType(), spawn.biomes().getBiomes());
			}
			if(entityClass.isAnnotationPresent(EntityEgg.class)){
				Random random = new Random((long)name.hashCode());
				EntityList.entityEggs.put(randomId, new EntityEggInfo(randomId, random.nextInt(), random.nextInt()));
			}
		}
	}
	
	public static void registerItem(Item item){ if(isItemRegisterable(item)) GameRegistry.registerItem(item, ((INamed)item).getRegistryName()); }
	
	public static void registerItemList(RegistryList<? extends Item> itemList){
		if(isListRegisterable(itemList)) for(ObjectEntry<? extends Item> entry: itemList) GameRegistry.registerItem(entry.getObject(), entry.getRegistryName());
	}
	
}

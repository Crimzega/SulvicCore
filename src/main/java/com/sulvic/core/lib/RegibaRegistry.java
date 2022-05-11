package com.sulvic.core.lib;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Type;
import java.util.Set;

import com.sulvic.core.common.entity.EnumEntityBiomes;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager.BiomeType;

@Retention(RUNTIME)
@Target({TYPE})
public @interface RegibaRegistry{
	
	@Retention(RUNTIME)
	@Target({TYPE})
	public @interface BiomeData{
		
		BiomeType value();
		
		int weight() default 4;
		
		boolean spawnHere() default false;
		
		boolean villages() default false;
		
		boolean strongholds() default false;
		
		BiomeDictionary.Type[] types() default {};
		
	}
	
	@Retention(RUNTIME)
	@Target({TYPE})
	public @interface EntityData{
		
		String name();
		
		int trackRange() default 64;
		
		int updateFreq() default 1;
		
		boolean sendsVelUpdate() default true;
		
	}
	
	@Retention(RUNTIME)
	@Target({TYPE})
	public @interface EntitySpawn{
		
		EnumCreatureType creatureType() default EnumCreatureType.creature;
		
		int weight() default 4;
		
		int min() default 0;
		
		int max() default 1;
		
		EnumEntityBiomes biomes() default EnumEntityBiomes.UNKNOWN;
		
	}
	
	@Retention(RUNTIME)
	@Target({TYPE})
	public @interface EntityEgg{
		
		int mainColor() default 0xFFFFFF;
		
		int secondColor() default 0xFFFFFF;
		
	}
	
	public interface IBlock{
		
		Class<? extends ItemBlock> itemClass();
		
	}
	
	public interface IItemArgs{
		
		Object[] ctorArgs();
		
	}
	
	public interface INamed{
		
		String getRegistryName();
		
	}
	
	public interface IRegList<E> {
		
		E getObject(int index);
		
		boolean addObject(E e, String name);
		
		boolean objectsAreOf(Class<?> aClass);
		
		int size();
		
		Set<E> objectSet();
		
		Set<String> nameSet();
		
		String getRegistryName(int index);
		
		Type getType();
		
	}
	
}

package com.sulvic.core.integration.mods;

import static thaumcraft.api.aspects.Aspect.*;

import java.util.Map;

import com.google.common.collect.Maps;
import com.sulvic.core.common.SulvicObjects;
import com.sulvic.core.integration.core.*;
import com.sulvic.core.lib.*;
import com.sulvic.core.lib.GemstoneData.Type;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.AspectList;

@ModIntegration("Thaumcraft")
public class SulvicThaumcraft implements IModHandler{
	
	private void addAspects(Block block, AspectList aspects){ addAspects(block, 0, aspects); }
	
	private void addAspects(Block block, int metadata, AspectList aspects){ addAspects(new ItemStack(block, 1, metadata), aspects); }
	
	private void addAspects(Item item, AspectList aspects){ addAspects(item, 0, aspects); }
	
	private void addAspects(Item item, int metadata, AspectList aspects){ addAspects(new ItemStack(item, 1, metadata), aspects); }
	
	private void addAspects(ItemStack stack, AspectList aspects){ ThaumcraftApi.registerObjectTag(stack, aspects); }
	
	public void postInit(FMLPostInitializationEvent evt){
		for(IGemstone gem: GemstoneData.getGems()){
			AspectList aspects = GemAspects.getAspectsFor(gem);
			addAspects(SulvicObjects.GEMS, gem.getMetadata(), aspects);
			aspects = new AspectList().add(aspects).add(EARTH, 1);
			addAspects(SulvicObjects.GEM_ORES, gem.getMetadata(), aspects);
			aspects = new AspectList().add(aspects).add(EARTH, 1).add(FIRE, 1);
			if(RegibaRegistration.isRegistered(SulvicNetherOres.NETHER_GEM_ORES)) addAspects(SulvicNetherOres.NETHER_GEM_ORES, gem.getMetadata(), aspects);
		}
		addAspects(SulvicObjects.CITRUS_LOG, new AspectList().add(TREE, 4));
		addAspects(SulvicObjects.CITRUS_LEAVES, new AspectList().add(PLANT, 1));
		addAspects(SulvicObjects.CITRUS_PLANKS, new AspectList().add(TREE, 1));
		addAspects(SulvicObjects.CITRUS_SAPLING, new AspectList().add(PLANT, 2).add(TREE, 1));
		addAspects(SulvicObjects.SPECIAL_ORE, new AspectList().add(ENERGY, 4).add(FIRE, 2));
		addAspects(SulvicObjects.SPECIAL_DUST, new AspectList().add(ENERGY, 3));
	}
	
	public static class GemAspects{
		
		private static final Map<IGemstone, AspectList> GEM_ASPECTS = Maps.newHashMap();
		
		static{
			addGemAspects(Type.RUBY, 2, 2);
			addGemAspects(Type.PINK_PANTHER, 6, 4);
			addGemAspects(Type.SAPPHIRE, 3, 6);
			addGemAspects(Type.CASSITERITE, 4, 3);
			addGemAspects(Type.ENSTATITE, 3, 5);
			addGemAspects(Type.MOONSTONE, 5, 2);
			addGemAspects(Type.AQUAMARINE, 2, 5);
			addGemAspects(Type.CITRINE, 3, 4);
			addGemAspects(Type.TOURMALINE, 2, 3);
			addGemAspects(Type.PERIDOT, 3, 2);
			addGemAspects(Type.BERYL, 2, 4);
			addGemAspects(Type.FIRE_AGATE, 4, 4);
			addGemAspects(Type.DRUZY, 4, 5);
			addGemAspects(Type.AMETRINE, 5, 6);
			addGemAspects(Type.ONYX, 3, 3);
		}
		
		public static void addGemAspects(IGemstone gem, int greedCount, int crystalCount){
			if(!GEM_ASPECTS.containsKey(gem)) GEM_ASPECTS.put(gem, new AspectList().add(GREED, greedCount).add(CRYSTAL, crystalCount));
		}
		
		public static AspectList getAspectsFor(IGemstone gem){ return GEM_ASPECTS.containsKey(gem)? GEM_ASPECTS.get(gem): new AspectList().add(GREED, 1).add(CRYSTAL, 1); }
		
	}
	
}

package com.sulvic.core.integration.mods;

import java.util.Map;

import com.google.common.collect.Maps;
import com.sulvic.core.common.SulvicObjects;
import com.sulvic.core.integration.core.IModHandler;
import com.sulvic.core.integration.core.ModIntegration;
import com.sulvic.core.lib.GemstoneData;
import com.sulvic.core.lib.GemstoneData.Type;
import com.sulvic.core.lib.IGemstone;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import moze_intel.projecte.api.ProjectEAPI;
import moze_intel.projecte.api.proxy.IEMCProxy;
import net.minecraft.item.ItemStack;

@ModIntegration({"ProjectE"})
public class SulvicProjectE implements IModHandler{
	
	public void postInit(FMLPostInitializationEvent evt){
		IEMCProxy emcProxy = ProjectEAPI.getEMCProxy();
		for(IGemstone gem: GemstoneData.getGems()) emcProxy.registerCustomEMC(new ItemStack(SulvicObjects.GEMS, 1, gem.getMetadata()), GemEMC.getEMC(gem));
		emcProxy.registerCustomEMC(SulvicObjects.SPECIAL_DUST, 576);
	}
	
	public static class GemEMC{
		
		private static final Map<IGemstone, Integer> GEM_EMCS = Maps.newHashMap();
		
		static{
			addGemEMC(Type.RUBY, 3584);
			addGemEMC(Type.PINK_PANTHER, 2560);
			addGemEMC(Type.SAPPHIRE, 5632);
			addGemEMC(Type.CASSITERITE, 4608);
			addGemEMC(Type.ENSTATITE, 6656);
			addGemEMC(Type.MOONSTONE, 6144);
			addGemEMC(Type.AQUAMARINE, 4096);
			addGemEMC(Type.CITRINE, 2304);
			addGemEMC(Type.TOURMALINE, 3328);
			addGemEMC(Type.PERIDOT, 2880);
			addGemEMC(Type.BERYL, 3840);
			addGemEMC(Type.FIRE_AGATE, 4032);
			addGemEMC(Type.DRUZY, 7680);
			addGemEMC(Type.AMETRINE, 7168);
			addGemEMC(Type.ONYX, 4224);
		}
		
		public static void addGemEMC(IGemstone gem, int amount){ if(!GEM_EMCS.containsKey(gem)) GEM_EMCS.put(gem, amount); }
		
		public static int getEMC(IGemstone gem){ return GEM_EMCS.containsKey(gem)? GEM_EMCS.get(gem): 128; }
		
	}
	
}

package com.sulvic.core;

import com.sulvic.core.client.config.ConfigCore;
import com.sulvic.core.common.HokurmiRecipes;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.common.SulvicObjects;
import com.sulvic.core.handler.SulvicMasterHandler;
import com.sulvic.core.integration.IntegrationHandler;
import com.sulvic.core.lib.GemstoneData;
import com.sulvic.core.logger.MezidaLogger;
import com.sulvic.core.proxy.AlvontixProxy;
import com.sulvic.core.world.gen.WorldVeinGen;
import com.sulvic.core.world.vein.GemstoneVein;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = ReferenceSC.MODID, name = ReferenceSC.NAME, version = ReferenceSC.VERSION)
public class SulvicCore{
	
	@Instance(ReferenceSC.MODID)
	public static SulvicCore instance;
	@SidedProxy(clientSide = ReferenceSC.CLIENT, serverSide = ReferenceSC.SERVER)
	public static AlvontixProxy proxy;
	private ConfigCore config;
	private MezidaLogger logger;
	
	public SulvicCore(){
		logger = new MezidaLogger(SulvicCore.class);
		logger.info("The \"{}\" logger has been created, now users will be informed on all of the bullshit. (Yes, I'm aware of my logger. Sue me)", getClass().getSimpleName());
		Items.bucket.setMaxStackSize(32);
		Items.egg.setMaxStackSize(32);
		Items.ender_pearl.setMaxStackSize(32);
		Items.iron_door.setMaxStackSize(32);
		Items.snowball.setMaxStackSize(32);
		Items.wooden_hoe.setMaxStackSize(32);
	}
	
	public static ConfigCore getConfig(){ return instance.config; }
	
	public static MezidaLogger getLogger(){ return instance.logger; }
	
	public static <T> RegistryList<T> newRegistryList(){ return new RegistryList<>(); }
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent evt){
		logger.info("The PreInit functionality.");
		config = new ConfigCore(evt, "sulvic/core.cfg", "1.0", true);
		config.buildConfig();
		OreDictionary.registerOre("button", Blocks.wooden_button);
		OreDictionary.registerOre("button", Blocks.stone_button);
		GemstoneData.build();
		GemstoneVein.init();
		FMLCommonHandler.instance().bus().register(SulvicMasterHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(SulvicMasterHandler.INSTANCE);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent evt){
		SulvicObjects.init();
		JemurinMaterial.addRepairItems();
		SulvicMasterHandler.getConfigPileBlocks();
		if(evt.getSide() == Side.CLIENT) SulvicObjects.addFancyItems();
		IntegrationHandler.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent evt){
		SulvicObjects.registerAll();
		HokurmiRecipes.addRecipes();
		GameRegistry.registerWorldGenerator(WorldVeinGen.instance(), 0);
		IntegrationHandler.postInitHandlers(evt);
	}
	
}

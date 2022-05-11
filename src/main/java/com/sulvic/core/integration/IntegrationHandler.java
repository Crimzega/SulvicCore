package com.sulvic.core.integration;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;
import com.sulvic.core.integration.core.IModHandler;
import com.sulvic.core.integration.core.ModIntegration;
import com.sulvic.core.integration.mods.SulvicDust;
import com.sulvic.core.integration.mods.SulvicExNihilo;
import com.sulvic.core.integration.mods.SulvicGalatricraft;
import com.sulvic.core.integration.mods.SulvicNetherOres;
import com.sulvic.core.integration.mods.SulvicProjectE;
import com.sulvic.core.integration.mods.SulvicThaumcraft;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameData;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.util.StringUtils;

public class IntegrationHandler{
	
	private static final List<IModHandler> HANDLERS = Lists.newArrayList();
	
	private static void becomeSpiderQueen(){
		Iterator<Item> iterator = GameData.getItemRegistry().iterator();
		while(iterator.hasNext()){
			Item item = iterator.next();
			if(item instanceof ItemFood) ((ItemFood)item).setAlwaysEdible();
		}
	}
	
	public static void init(){
		applyModHandler(SulvicNetherOres.class);
		applyModHandler(SulvicDust.SulvicAppEng2.class);
		applyModHandler(SulvicDust.SulvicIC2.class);
		applyModHandler(SulvicGalatricraft.class);
		applyModHandler(SulvicProjectE.class);
		applyModHandler(SulvicExNihilo.class);
		applyModHandler(SulvicThaumcraft.class);
	}
	
	private static boolean canIntegrate(Class<? extends IModHandler> handlerClass){
		ModIntegration integration = handlerClass.getAnnotation(ModIntegration.class);
		if(integration != null){
			String[] modids = integration.value();
			if(modids.length > 0){
				String modid = modids[0];
				boolean flag = !StringUtils.isNullOrEmpty(modid) && Loader.isModLoaded(modid);
				for(int i = 1; i < modids.length; i++){
					if(!flag) break;
					modid = modids[i];
					flag &= !StringUtils.isNullOrEmpty(modid) && Loader.isModLoaded(modid);
				}
				return flag;
			}
			else return false;
		}
		else return false;
	}
	
	public static void applyModHandler(Class<? extends IModHandler> handlerClass, Object... inits){
		if(canIntegrate(handlerClass)){
			Class<?>[] initClasses = new Class<?>[inits.length];
			for(int i = 0; i < inits.length; i++) initClasses[i] = inits[i].getClass();
			IModHandler handler = null;
			try{
				handler = handlerClass.getConstructor(initClasses).newInstance(inits);
			}
			catch(InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException ex){
				ex.printStackTrace();
			}
			if(handler != null) HANDLERS.add(handler);
		}
	}
	
	public static void postInitHandlers(FMLPostInitializationEvent evt){
		if(Loader.isModLoaded("SQ")) becomeSpiderQueen();
		for(IModHandler handler: HANDLERS) handler.postInit(evt);
	}
	
}

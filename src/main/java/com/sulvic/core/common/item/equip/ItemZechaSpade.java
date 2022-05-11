package com.sulvic.core.common.item.equip;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.item.ItemSpade;

@RegibaRegistry
public class ItemZechaSpade extends ItemSpade implements INamed{
	
	public ItemZechaSpade(){
		super(JemurinMaterial.ZECHA_TOOL_MATERIAL);
		setCreativeTab(FolkrumTabs.TOOLS);
		setTextureName(ReferenceSC.MODID + ":tools/zecha_shovel");
		setUnlocalizedName("zechaSpade");
	}
	
	public String getRegistryName(){ return "zecha_spade"; }
	
}

package com.sulvic.core.common.item.equip;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.item.ItemSpade;

@RegibaRegistry
public class ItemSpecialSpade extends ItemSpade implements INamed{
	
	public ItemSpecialSpade(){
		super(JemurinMaterial.SPECIAL_TOOL_MATERIAL);
		setCreativeTab(FolkrumTabs.TOOLS);
		setTextureName(ReferenceSC.MODID + ":tools/special_shovel");
		setUnlocalizedName("specialSpade");
	}
	
	public String getRegistryName(){ return "special_spade"; }
	
}

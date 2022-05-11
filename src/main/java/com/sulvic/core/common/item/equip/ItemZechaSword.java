package com.sulvic.core.common.item.equip;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.common.JemurinMaterial;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;

import net.minecraft.item.ItemSword;

@RegibaRegistry
public class ItemZechaSword extends ItemSword implements INamed{
	
	public ItemZechaSword(){
		super(JemurinMaterial.ZECHA_TOOL_MATERIAL);
		setCreativeTab(FolkrumTabs.EQUIP);
		setTextureName(ReferenceSC.MODID + ":tools/zecha_sword");
		setUnlocalizedName("zechaSword");
	}
	
	public String getRegistryName(){ return "zecha_sword"; }
	
}

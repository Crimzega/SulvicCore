package com.sulvic.core.common.item.equip;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.FolkrumTabs;
import com.sulvic.core.lib.GemstoneData;
import com.sulvic.core.lib.IGemstone;
import com.sulvic.core.proxy.AlvontixClient;
import com.sulvic.core.util.ArmorType;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StringUtils;

public class ItemGemArmor extends ItemArmor{
	
	private ArmorType armorType;
	private IGemstone gemType;
	@AlvontixClient
	private IIcon glintIcon;
	
	public ItemGemArmor(IGemstone type, ArmorType armor){
		super(GemstoneData.getGemArmorMaterial(type), 3, armor.getArmorIndex());
		setCreativeTab(FolkrumTabs.EQUIP);
		setUnlocalizedName(type.getUnlocalName() + armor.getUnlocalName());
		gemType = type;
		armorType = armor;
	}
	
	public boolean getIsRepairable(ItemStack stack, ItemStack stack1){ return getArmorMaterial().func_151685_b() == stack1.getItem() && stack1.getItemDamage() == gemType.getMetadata(); }
	
	public boolean hasColor(ItemStack stack){ return true; }
	
	@AlvontixClient
	public boolean requiresMultipleRenderPasses(){ return true; }
	
	@AlvontixClient
	public IIcon getIconFromDamageForRenderPass(int damage, int pass){ return pass == 1? glintIcon: itemIcon; }
	
	public int getColor(ItemStack stack){ return GemstoneData.getGemColor(gemType); }
	
	@AlvontixClient
	public int getColorFromItemStack(ItemStack stack, int pass){
		int color = getColor(stack);
		return pass == 1? 0xFFFFFF: color < 0? 0xFFFFFF: color;
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		return ReferenceSC.MODID + ":textures/armor/colored/" + (StringUtils.isNullOrEmpty(type)? "base": "glint") + "_layer" + (armorType == ArmorType.LEGGINGS? 2: 1) + ".png";
	}
	
	@AlvontixClient
	public void registerIcons(IIconRegister registry){
		itemIcon = registry.registerIcon(ReferenceSC.MODID + ":armor/colored/base_" + armorType.getName());
		glintIcon = registry.registerIcon(ReferenceSC.MODID + ":armor/colored/glint_" + armorType.getName());
	}
	
}

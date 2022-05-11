package com.sulvic.core.common;

import java.util.List;

import com.google.common.collect.Lists;
import com.sulvic.core.RegistryList;
import com.sulvic.core.SulvicCore;
import com.sulvic.core.common.block.*;
import com.sulvic.core.common.entity.EntityBrokenSkull;
import com.sulvic.core.common.item.*;
import com.sulvic.core.common.item.equip.*;
import com.sulvic.core.common.item.food.*;
import com.sulvic.core.lib.*;
import com.sulvic.core.lib.GemstoneData.Type;
import com.sulvic.core.proxy.*;
import com.sulvic.core.util.ArmorType;
import com.sulvic.core.world.biome.*;

import net.minecraft.item.*;

public class SulvicObjects{
	
	@AlvontixClient
	private static final List<IFancy> fancyTextureables = Lists.newArrayList();
	private static final RegistryList<ItemGemArmor> GEM_ARMOR = SulvicCore.newRegistryList();
	private static final RegistryList<ItemGemSword> GEM_SWORDS = SulvicCore.newRegistryList();
	private static final RegistryList<ItemTool> GEM_TOOLS = SulvicCore.newRegistryList();
	private static final RegistryList<ItemGemHoe> GEM_HOES = SulvicCore.newRegistryList();
	protected static final RegistryList<ItemSpecialArmor> SPECIAL_ARMOR = SulvicCore.newRegistryList();
	protected static final RegistryList<ItemZechaArmor> ZECHA_ARMOR = SulvicCore.newRegistryList();
	public static final LogCitrus CITRUS_LOG = new LogCitrus();
	public static final LeavesCitrus CITRUS_LEAVES = new LeavesCitrus();
	public static final SaplingCitrus CITRUS_SAPLING = new SaplingCitrus();
	public static final BlockCitrusPlanks CITRUS_PLANKS = new BlockCitrusPlanks();
	public static final StairsCitrus CITRUS_STAIRS = new StairsCitrus();
	public static final SlabCitrus CITRUS_SLAB = new SlabCitrus(false), CITRUS_DOUBLE_SLAB = new SlabCitrus(true);
	public static final OreGem GEM_ORES = new OreGem();
	public static final OreSpecial SPECIAL_ORE = new OreSpecial();
	public static final OreZecha ZECHA_ORE = new OreZecha();
	public static final BlockGem GEM_BLOCKS = new BlockGem();
	public static final BlockSpecial SPECIAL_BLOCK = new BlockSpecial();
	public static final BlockZecha ZECHA_BLOCK = new BlockZecha();
	public static final CropSweetPotato SWEET_POTATO_CROP = new CropSweetPotato();
	public static final PileSugar SUGAR_PILE = new PileSugar();
	public static final ItemGem GEMS = new ItemGem();
	public static final ItemSpecialDust SPECIAL_DUST = new ItemSpecialDust();
	public static final ItemSpecialIngot SPECIAL_INGOT = new ItemSpecialIngot();
	public static final ItemZechaIngot ZECHA_INGOT = new ItemZechaIngot();
	public static final ItemSweetPotato SWEET_POTATO = new ItemSweetPotato();
	public static final ItemEnergyBar ENERGY_BAR = new ItemEnergyBar();
	public static final ItemSpecialSword SPECIAL_SWORD = new ItemSpecialSword();
	public static final ItemSpecialSpade SPECIAL_SPADE = new ItemSpecialSpade();
	public static final ItemSpecialPickaxe SPECIAL_PICKAXE = new ItemSpecialPickaxe();
	public static final ItemSpecialAxe SPECIAL_AXE = new ItemSpecialAxe();
	public static final ItemSpecialHoe SPECIAL_HOE = new ItemSpecialHoe();
	public static final ItemZechaSword ZECHA_SWORD = new ItemZechaSword();
	public static final ItemZechaSpade 	ZECHA_SPADE = new ItemZechaSpade();
	public static final ItemZechaPickaxe ZECHA_PICKAXE = new ItemZechaPickaxe();
	public static final ItemZechaAxe ZECHA_AXE = new ItemZechaAxe();
	public static final ItemZechaHoe ZECHA_HOE = new ItemZechaHoe();
	public static final BiomeFlatlands FLATLANDS = new BiomeFlatlands();
	public static final BiomeCitrusGrove CITRUS_GROVE = new BiomeCitrusGrove();
	
	public static void init(){
		for(Type type: Type.values()){
			GemstoneData.getGemArmorMaterial(type).customCraftingMaterial = GEMS;
			GemstoneData.getGemToolMaterial(type).setRepairItem(new ItemStack(GEMS, 1, type.getMetadata()));
			String typeName = type.getName();
			for(ArmorType armor: ArmorType.values()) GEM_ARMOR.addObject(new ItemGemArmor(type, armor), typeName + "_" + armor.getName());
			GEM_SWORDS.addObject(new ItemGemSword(type), typeName + "_sword");
			GEM_TOOLS.addObject(new ItemGemSpade(type), typeName + "_spade");
			GEM_TOOLS.addObject(new ItemGemPickaxe(type), typeName + "_pickaxe");
			GEM_TOOLS.addObject(new ItemGemAxe(type), typeName + "_axe");
			GEM_HOES.addObject(new ItemGemHoe(type), typeName + "_hoe");
		}
		for(ArmorType type: ArmorType.values()) {
			SPECIAL_ARMOR.addObject(new ItemSpecialArmor(type), "special_" + type.getName());
			ZECHA_ARMOR.addObject(new ItemZechaArmor(type), "zecha_" + type.getName());
		}
	}
	
	@AlvontixClient
	public static void addFancyItems(){ fancyTextureables.add(CITRUS_LEAVES); }
	
	@AlvontixClient
	public static void setFancyTextures(boolean fancyTex){ for(IFancy fancy: fancyTextureables) fancy.setFancyGraphics(fancyTex); }
	
	public static ItemGemArmor getGemArmor(IGemstone type, ArmorType armor){ return GEM_ARMOR.getObject(type.getMetadata() * 4 + armor.getArmorIndex()); }
	
	public static ItemGemAxe getGemAxe(IGemstone type){ return (ItemGemAxe)GEM_TOOLS.getObject(type.getMetadata() * 3 + 2); }
	
	public static ItemGemHoe getGemHoe(IGemstone type){ return GEM_HOES.getObject(type.getMetadata()); }
	
	public static ItemGemPickaxe getGemPickaxe(IGemstone type){ return (ItemGemPickaxe)GEM_TOOLS.getObject(type.getMetadata() * 3 + 1); }
	
	public static ItemGemSpade getGemSpade(IGemstone type){ return (ItemGemSpade)GEM_TOOLS.getObject(type.getMetadata() * 3); }
	
	public static ItemGemSword getGemSword(IGemstone type){ return GEM_SWORDS.getObject(type.getMetadata()); }
	
	public static void registerAll(){
		RegibaRegistration.registerBlock(CITRUS_LOG);
		RegibaRegistration.registerBlock(CITRUS_LEAVES);
		RegibaRegistration.registerBlock(CITRUS_SAPLING);
		RegibaRegistration.registerBlock(CITRUS_PLANKS);
		RegibaRegistration.registerBlock(CITRUS_STAIRS);
		RegibaRegistration.registerBlock(CITRUS_SLAB);
		RegibaRegistration.registerBlock(CITRUS_DOUBLE_SLAB);
		RegibaRegistration.registerBlock(GEM_ORES);
		RegibaRegistration.registerBlock(SPECIAL_ORE);
		RegibaRegistration.registerBlock(ZECHA_ORE);
		RegibaRegistration.registerBlock(GEM_BLOCKS);
		RegibaRegistration.registerBlock(SPECIAL_BLOCK);
		RegibaRegistration.registerBlock(ZECHA_BLOCK);
		RegibaRegistration.registerBlock(SWEET_POTATO_CROP);
		RegibaRegistration.registerBlock(SUGAR_PILE);
		RegibaRegistration.registerItem(GEMS);
		RegibaRegistration.registerItem(SPECIAL_DUST);
		RegibaRegistration.registerItem(SPECIAL_INGOT);
		RegibaRegistration.registerItem(ZECHA_INGOT);
		RegibaRegistration.registerItem(SWEET_POTATO);
		RegibaRegistration.registerItem(ENERGY_BAR);
		RegibaRegistration.registerItemList(GEM_ARMOR);
		RegibaRegistration.registerItemList(SPECIAL_ARMOR);
		RegibaRegistration.registerItemList(ZECHA_ARMOR);
		RegibaRegistration.registerItemList(GEM_SWORDS);
		RegibaRegistration.registerItem(SPECIAL_SWORD);
		RegibaRegistration.registerItem(ZECHA_SWORD);
		RegibaRegistration.registerItemList(GEM_TOOLS);
		RegibaRegistration.registerItem(SPECIAL_SPADE);
		RegibaRegistration.registerItem(SPECIAL_PICKAXE);
		RegibaRegistration.registerItem(SPECIAL_AXE);
		RegibaRegistration.registerItem(ZECHA_SPADE);
		RegibaRegistration.registerItem(ZECHA_PICKAXE);
		RegibaRegistration.registerItem(ZECHA_AXE);
		RegibaRegistration.registerItemList(GEM_HOES);
		RegibaRegistration.registerItem(SPECIAL_HOE);
		RegibaRegistration.registerItem(ZECHA_HOE);
		RegibaRegistration.registerBiome(FLATLANDS);
		RegibaRegistration.registerBiome(CITRUS_GROVE);
		RegibaRegistration.registerEntity(EntityBrokenSkull.class, SulvicCore.instance);EntityList
	}
	
}

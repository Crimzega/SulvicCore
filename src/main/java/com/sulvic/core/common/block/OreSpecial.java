package com.sulvic.core.common.block;

import static com.sulvic.core.world.vein.core.VeinData.*;

import java.util.Random;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.*;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.INamed;
import com.sulvic.core.proxy.AlvontixClient;
import com.sulvic.core.world.vein.core.*;
import com.sulvic.util.SulvicMath;

import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

@RegibaRegistry
public class OreSpecial extends BlockBreakable implements INamed, IVein{
	
	public OreSpecial(){
		super(ReferenceSC.MODID + ":ores/special", JemurinMaterial.SPECIAL_MATERIAL, false);
		setCreativeTab(FolkrumTabs.BLOCKS);
		setBlockName("oreSpecial");
		setHardness(5f);
		setHarvestLevel("pickaxe", 3);
		setResistance(15f);
		setStepSound(soundTypeGlass);
	}
	
	protected boolean canSilkHarvest(){ return false; }
	
	@AlvontixClient
	public boolean renderAsNormalBlock(){ return false; }
	
	@AlvontixClient
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side){ return super.shouldSideBeRendered(blockAccess, x, y, z, side - 1); }
	
	@AlvontixClient
	public int getRenderBlockPass(){ return 1; }
	
	public int quantityDropped(Random random){ return SulvicMath.rangedInt(random, 3, 7); }
	
	public Item getItemDropped(int metadata, Random random, int fortune){ return SulvicObjects.SPECIAL_DUST; }
	
	public Block getOre(){ return this; }
	
	public VeinData getVeinData(){ return createData(11, 20, 3, 9, 18); }
	
	public String getRegistryName(){ return "ore_special"; }
	
}

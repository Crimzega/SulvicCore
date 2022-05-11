package com.sulvic.core.common.entity;

import static com.sulvic.util.SulvicMath.*;
import static net.minecraft.item.Item.*;

import java.util.Set;

import com.google.common.collect.Sets;
import com.sulvic.core.ReferenceSC;
import com.sulvic.core.common.entity.ai.EntityKeepDistanceAI;
import com.sulvic.core.lib.RegibaRegistry;
import com.sulvic.core.lib.RegibaRegistry.*;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

@RegibaRegistry
@EntityData(name = "BrokenSkull", trackRange = 32)
@EntitySpawn(creatureType = EnumCreatureType.monster, weight = 2, min = 2, max = 5, biomes = EnumEntityBiomes.BROKEN_SKULL)
@EntityEgg()
public class EntityBrokenSkull extends EntityCreature{
	
	protected static final int TEMP = 0xFFFF;
	protected static final double THROW_HEIGHT = 0.800000011920929D;
	
	private static final Set<Item> PICKUPS = Sets.newHashSet(Items.cake, getItemFromBlock(Blocks.sponge), Items.flower_pot, Items.bucket);
	private static final int MAX_COOLDOWN = 600;
	private int dropCooldown;
	private ItemStack heldItem;
	
	public EntityBrokenSkull(World world){ super(world); }
	
	public EntityBrokenSkull(World world, double posX, double posY, double posZ){
		this(world);
		setSize(1.5f, 2.875f);
		setPosition(posX, posY, posZ);
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIAttackOnCollide(this, 1d, true));
		tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9d, 32f));
		tasks.addTask(3, new EntityAIWander(this, 0.82d));
		tasks.addTask(2, new EntityAIRestrictSun(this));
		tasks.addTask(3, new EntityAIFleeSun(this, 1d));
		tasks.addTask(4, new EntityKeepDistanceAI(this, EntityZombie.class, 10f, 1.25d));
		tasks.addTask(4, new EntityKeepDistanceAI(this, EntitySkeleton.class, 10f, 1.25d));
		tasks.addTask(4, new EntityKeepDistanceAI(this, EntityCreeper.class, 10f, 1.25d));
		tasks.addTask(4, new EntityKeepDistanceAI(this, EntityEnderman.class, 10f, 1.25d));
		tasks.addTask(4, new EntityKeepDistanceAI(this, EntityWitch.class, 10f, 1.25d));
		tasks.addTask(4, new EntityKeepDistanceAI(this, EntityWolf.class, 10f, 2.75d));
		tasks.addTask(4, new EntityKeepDistanceAI(this, EntityOcelot.class, 10f, 2.75d));
		tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 12f));
		tasks.addTask(5, new EntityAIWatchClosest(this, EntityVillager.class, 10f));
		tasks.addTask(6, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	}
	
	protected Item getDropItem(){ return heldItem != null? heldItem.getItem(): null; }
	
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(9.75d);
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16d);
		getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(8d);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(250d);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.625f);
	}
	
	protected void entityInit(){
		super.entityInit();
		dataWatcher.addObject(16, Short.valueOf((short)0));
		dataWatcher.addObject(17, Short.valueOf((short)0));
	}
	
	public float getEyeHeight(){ return 2.6875f; }
	
	public boolean canPickUpLoot(){ return true; }
	
	public int getCarriedData(){ return dataWatcher.getWatchableObjectShort(17) & 65535; }
	
	public Item getCarried(){ return Item.getItemById(dataWatcher.getWatchableObjectShort(16) & 65535); }
	
	protected String getDeathSound(){ return ReferenceSC.MODID + ":broken_skull.death"; }
	
	protected String getHurtSound(){ return ReferenceSC.MODID + ":broken_skull.hurt"; }
	
	protected String getLivingSound(){ return ReferenceSC.MODID + ":broken_skull.idle"; }
	
	public void onUpdate(){
		super.onUpdate();
		if(heldItem != null){
			if(dropCooldown > 0) dropCooldown--;
			else{
				EntityItem entityItem = new EntityItem(worldObj);
				entityItem.setPositionAndRotation(posX, posY + getEyeHeight() / 2, posZ, rotationYaw, rotationPitch);
				entityItem.addVelocity(rangedDouble(rand, -0.25d, 0.25d), 0d, rangedDouble(rand, -0.25d, 0.25d));
				entityItem.setEntityItemStack(heldItem);
				heldItem = null;
			}
		}
	}
	
	public void setCarried(Item item){ dataWatcher.updateObject(16, (short)Item.getIdFromItem(item)); }
	
	public void setCarriedData(int metadata){ dataWatcher.updateObject(17, (short)metadata); }
	
	public void readEntityFromNBT(NBTTagCompound nbtCompound){
		super.readEntityFromNBT(nbtCompound);
		setCarried(Item.getItemById(nbtCompound.getShort("Carried")));
		setCarriedData(nbtCompound.getShort("CarriedData"));
		dropCooldown = nbtCompound.getInteger("TimeTillDrop");
	}
	
	public void writeEntityToNBT(NBTTagCompound nbtCompound){
		super.writeEntityToNBT(nbtCompound);
		nbtCompound.setShort("Carried", (short)Item.getIdFromItem(getCarried()));
		nbtCompound.setShort("CarriedData", (short)getCarriedData());
		nbtCompound.setInteger("TimeTillDrop", dropCooldown);
	}
	
	public void onDeath(DamageSource dmgSrc){
		Entity entity = dmgSrc.getEntity();
		if(entity != null){
			if(entity instanceof EntityZombie) dropItem(Items.brick, 1 + rangedInt(rand, 1, 3));
			if(entity instanceof EntitySkeleton) dropItem(Items.arrow, rangedInt(rand, 1, 2));
			if(entity instanceof EntityCreeper) dropItem(Items.gunpowder, rangedInt(rand, 0, 4));
			if(entity instanceof EntityWitch) dropItem(Items.book, rangedInt(rand, 1, 3));
			if(entity instanceof EntityEnderman) dropItem(Items.ender_eye, rangedInt(rand, 0, 2));
			if(entity instanceof EntityWolf || entity instanceof EntityOcelot) dropItem(Items.rotten_flesh, rangedInt(rand, 1, 5));
		}
	}
	
	public void onItemPickup(Entity entity, int par){
		if(entity instanceof EntityItem && dropCooldown == 0){
			EntityItem entityItem = (EntityItem)entity;
			ItemStack stack = entityItem.getEntityItem();
			if(PICKUPS.contains(stack.getItem())){
				if(stack.stackSize >= 1) stack.stackSize--;
				setCarried(stack.getItem());
				setCarriedData(stack.getItemDamage());
				dropCooldown = MAX_COOLDOWN;
			}
		}
	}
	
}

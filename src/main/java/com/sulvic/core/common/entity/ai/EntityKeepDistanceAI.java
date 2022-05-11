package com.sulvic.core.common.entity.ai;

import java.util.List;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;

@SuppressWarnings({"rawtypes"})
public class EntityKeepDistanceAI extends EntityAIBase{
	
	private final IEntitySelector theSelector = new IEntitySelector(){
		
		public boolean isEntityApplicable(Entity entity){ return entity.isEntityAlive() && theCreature.getEntitySenses().canSee(entity); }
	};
	private Class<? extends EntityLivingBase> avoidedEntityClass;
	private Entity closestEntity;
	private double entitySpeed;
	private EntityCreature theCreature;
	private float minimumDistance;
	private PathEntity pathEntity;
	private PathNavigate pathNavigate;
	
	public EntityKeepDistanceAI(EntityCreature creature, Class<? extends EntityLivingBase> livingBaseClass, float minDist, double speed){
		theCreature = creature;
		avoidedEntityClass = livingBaseClass;
		minimumDistance = minDist;
		entitySpeed = speed;
		pathNavigate = creature.getNavigator();
	}
	
	public boolean continueExecuting(){ return !pathNavigate.noPath(); }
	
	public boolean shouldExecute(){
		List list = theCreature.worldObj.selectEntitiesWithinAABB(avoidedEntityClass, theCreature.getBoundingBox().expand(minimumDistance, 2d, minimumDistance), theSelector);
		if(list.isEmpty()) return false;
		closestEntity = (Entity)list.get(0);
		Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockAwayFrom(theCreature, 13, 7, Vec3.createVectorHelper(theCreature.posX, theCreature.posY, theCreature.posZ));
		if(vec3 == null) return false;
		else if(closestEntity.getDistanceSq(vec3.xCoord, vec3.yCoord, vec3.zCoord) < closestEntity.getDistanceSqToEntity(theCreature)) return false;
		else{
			pathEntity = pathNavigate.getPathToXYZ(vec3.xCoord, vec3.yCoord, vec3.zCoord);
			return pathEntity == null? false: pathEntity.isDestinationSame(vec3);
		}
	}
	
	public void resetTask(){ closestEntity = null; }
	
	public void startExecuting(){ pathNavigate.setPath(pathEntity, entitySpeed); }
	
	public void updateTask(){ pathNavigate.setSpeed(entitySpeed); }
	
}

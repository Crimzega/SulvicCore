package com.sulvic.core.client.render;

import com.sulvic.core.ReferenceSC;
import com.sulvic.core.client.model.ModelBrokenSkull;
import com.sulvic.core.common.entity.EntityBrokenSkull;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderBrokenSkull extends RenderLiving{
	
	private static final ResourceLocation BROKEN_SKULL = new ResourceLocation(ReferenceSC.MODID, "textures/entity/broken_skull.png");
	
	public RenderBrokenSkull(){ super(new ModelBrokenSkull(), 1.5f); }
	
	protected ResourceLocation getEntityTexture(EntityBrokenSkull brokenSkull){ return BROKEN_SKULL; }
	
	protected ResourceLocation getEntityTexture(Entity entity){ return getEntityTexture((EntityBrokenSkull)entity); }
	
	public void renderBrokenSkull(EntityBrokenSkull brokenSkull, double posX, double posY, double posZ, float rotationYaw, float rotationPitch){
		super.doRender(brokenSkull, posX, posY, posZ, rotationYaw, rotationPitch);
	}
	
	public void doRender(Entity entity, double posX, double posY, double posZ, float rotationYaw, float rotationPitch){
		renderBrokenSkull((EntityBrokenSkull)entity, posX, posY, posZ, rotationYaw, rotationPitch);
	}
	
	public void doRender(EntityLiving living, double posX, double posY, double posZ, float rotationYaw, float rotationPitch){
		renderBrokenSkull((EntityBrokenSkull)living, posX, posY, posZ, rotationYaw, rotationPitch);
	}
	
}

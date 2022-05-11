package com.sulvic.core.client.model;

import static com.sulvic.core.client.model.ModelRenderHelper.*;
import static com.sulvic.util.SulvicMath.*;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBrokenSkull extends ModelBase{
	
	public ModelRenderer head, jaw, upperTorso, armL, armR, lowerTorso, legL, legR;
	
	public ModelBrokenSkull(){
		textureWidth = 92;
		textureHeight = 50;
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-5f, -8f, -10f, 10, 8, 10);
		head.setRotationPoint(0f, -14f, -4f);
		setRotationOffset(head, 0f, 0f, 0f);
		jaw = new ModelRenderer(this, 0, 18);
		jaw.addBox(-5f, 0f, -10f, 10, 2, 10);
		jaw.setRotationPoint(0f, -14f, -4f);
		setRotationOffset(jaw, 0f, 0f, getRotationFloat(20f));
		upperTorso = new ModelRenderer(this, 40, 0);
		upperTorso.addBox(-8f, 0f, -5f, 16, 12, 10);
		upperTorso.setRotationPoint(0f, -13.5f, -4.7f);
		setRotationOffset(upperTorso, 0f, 0f, getRotationFloat(20f));
		armL = new ModelRenderer(this, 44, 22);
		armL.addBox(-2f, -2f, 4f, 4, 22, 6);
		armL.setRotationPoint(10f, -12f, -3f);
		armL.mirror = true;
		setRotationOffset(armL, 0f, 0f, 0f);
		armR = new ModelRenderer(this, 44, 22);
		armR.addBox(-2f, -2f, 4f, 4, 22, 6);
		armR.setRotationPoint(10f, -12f, -3f);
		setRotationOffset(armR, 0f, 0f, 0f);
		lowerTorso = new ModelRenderer(this, 0, 30);
		lowerTorso.addBox(-7f, 0f, -4f, 14, 10, 8);
		lowerTorso.setRotationPoint(0f, -4f, 0f);
		setRotationOffset(lowerTorso, 0f, 0f, 0f);
		legL = new ModelRenderer(this, 64, 22);
		legL.addBox(-2f, 0f, 3f, 4, 18, 6);
		legL.setRotationPoint(4f, 6f, 0f);
		legL.mirror = true;
		legR = new ModelRenderer(this, 64, 22);
		legR.addBox(-2f, 0f, -3f, 4, 18, 6);
		legR.setRotationPoint(-4f, 6f, 0f);
		applyTextureSizesFrom(this, head, jaw, upperTorso, armL, armR, lowerTorso, legL, legR);
	}
	
	public void render(Entity entity, float par, float par1, float par2, float par3, float par4, float par5){
		super.render(entity, par, par1, par2, par3, par4, par5);
		setRotationAngles(par, par1, par2, par3, par4, par5, entity);
		head.render(par5);
		jaw.render(par5);
		upperTorso.render(par5);
		lowerTorso.render(par5);
		armL.render(par5);
		armR.render(par5);
		lowerTorso.render(par5);
		legL.render(par5);
		legR.render(par5);
	}
	
	public void setRotationAngles(float par, float par1, float par2, float par3, float par4, float par5, Entity entity){
		super.setRotationAngles(par, par1, par2, par3, par4, par5, entity);
		
	}
	
}

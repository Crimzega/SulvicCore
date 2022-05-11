package com.sulvic.core.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelRenderHelper{
	
	public static void setRotationOffset(ModelRenderer renderer, float x, float y, float z){
		renderer.rotateAngleX = x;
		renderer.rotateAngleY = y;
		renderer.rotateAngleZ = z;
	}
	
	public static void applyTextureSizesFrom(ModelBase base, ModelRenderer... renderers){
		for(ModelRenderer renderer: renderers) renderer.setTextureSize(base.textureWidth, base.textureHeight);
	}
	
}

package com.sulvic.util;

import java.awt.Color;

public class ColorBlender{
	
	public static int blendColors(int baseRGB, int blendRGB, EnumMode mode){ return mode.getModeColor(new Color(baseRGB), new Color(blendRGB)).getRGB(); }
	
	public static int blendColors(int baseRGB, int blendRGB, float opacity, EnumMode mode){ return mode.getModeColor(new Color(baseRGB), new Color(blendRGB), opacity).getRGB(); }
	
	public static enum EnumMode{
		
		AVERAGE,
		COLOR_BURN,
		COLOR_DODGE,
		DARKEN,
		DIFFERENCE,
		EXCLUSION,
		GLOW,
		HARD_LIGHT,
		HARD_MIX,
		LIGHTEN,
		LINEAR_BURN,
		LINEAR_DODGE,
		LINEAR_LIGHT,
		MULTIPLY,
		NEGATION,
		NORMAL,
		OVERLAY,
		PHOENIX,
		PIN_LIGHT,
		REFLECT,
		SOFT_LIGHT,
		SUBTRACT,
		VIVID_LIGHT;
		
		private float getModeValue(float baseV, float blendV){
			switch(this){
				case AVERAGE:
					return (baseV + blendV) / 2f;
				case COLOR_BURN:
					return (blendV == 0f)? blendV: Math.max(1f - (1f - baseV) / blendV, 0f);
				case COLOR_DODGE:
					return (blendV == 1f)? blendV: Math.min(baseV / (1f - blendV), 1f);
				case DARKEN:
					return Math.min(baseV, blendV);
				case DIFFERENCE:
					return Math.abs(baseV - blendV);
				case EXCLUSION:
					return baseV + blendV - 2f * baseV * blendV;
				case GLOW:
					return REFLECT.getModeValue(baseV, blendV);
				case HARD_LIGHT:
					return OVERLAY.getModeValue(baseV, blendV);
				case HARD_MIX:
					return VIVID_LIGHT.getModeValue(baseV, blendV);
				case LIGHTEN:
					return Math.max(baseV, blendV);
				case LINEAR_BURN:
					return Math.max(baseV + blendV - 1f, 0f);
				case LINEAR_DODGE:
					return Math.min(baseV + blendV, 1f);
				case LINEAR_LIGHT:
					return blendV < 0.5f? LINEAR_BURN.getModeValue(baseV, 2f * blendV): LINEAR_LIGHT.getModeValue(baseV, 2f * (blendV - 0.5f));
				case MULTIPLY:
					return baseV * blendV;
				case NEGATION:
					return 1f - Math.abs(1f - baseV - blendV);
				case OVERLAY:
					return baseV < 0.5f? 2f * baseV * blendV: (1f - 2f * (1f - baseV) * (1f - blendV));
				case PHOENIX:
					return Math.min(baseV, blendV) - Math.max(baseV, blendV) + 1f;
				case PIN_LIGHT:
					return blendV < 0.5f? DARKEN.getModeValue(baseV, 2f * blendV): LIGHTEN.getModeValue(baseV, 2f * (blendV - 0.5f));
				case REFLECT:
					return blendV == 1f? blendV: Math.min(baseV * baseV / (1f - blendV), 1f);
				case SOFT_LIGHT:
					return blendV < 0.5f? 2f * baseV * blendV + baseV * baseV * (1f - 2f * blendV): (float)Math.sqrt(baseV) * (2f * blendV - 1f) + 2f * baseV * (1f - blendV);
				case SUBTRACT:
					return Math.max(baseV + blendV - 1f, 0f);
				case VIVID_LIGHT:
					return blendV < 0.5f? COLOR_BURN.getModeValue(baseV, 2f * blendV): COLOR_DODGE.getModeValue(baseV, 2f * (blendV - 0.5f));
				default:
					return blendV;
			}
		}
		
		private float getModeValue(float baseV, float blendV, float opacity){ return getModeValue(baseV, blendV) * opacity + baseV * (1f - opacity); }
		
		private float toRange(int value){ return value / 255f; }
		
		protected Color getModeColor(Color base, Color blend){
			float r = getModeValue(toRange(base.getRed()), toRange(blend.getRed())), g = getModeValue(toRange(base.getGreen()), toRange(blend.getGreen())),
				b = getModeValue(toRange(base.getBlue()), toRange(blend.getBlue()));
			return new Color(r, g, b);
		}
		
		protected Color getModeColor(Color base, Color blend, float opacity){
			float r = getModeValue(toRange(base.getRed()), toRange(blend.getRed()), opacity), g = getModeValue(toRange(base.getGreen()), toRange(blend.getGreen()), opacity),
				b = getModeValue(toRange(base.getBlue()), toRange(blend.getBlue()), opacity);
			return new Color(r, g, b);
		}
		
	}
	
}

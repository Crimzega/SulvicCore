package com.sulvic.core.world.vein.core;

import java.util.Random;

import com.sulvic.util.SulvicMath;

public class VeinData{
	
	private int maxSize, maxY, minSize, minY, veinChance;
	
	private VeinData(int y, int y1){
		minY = y;
		maxY = y1;
	}
	
	public static VeinData createData(int y, int y1, int min, int max, int chance){ return new VeinData(y, y1).setVeinSize(min, max).setVeinChance(chance); }
	
	private VeinData setVeinSize(int min, int max){
		minSize = min;
		maxSize = max;
		return this;
	}
	
	private VeinData setVeinChance(int chance){
		veinChance = chance;
		return this;
	}
	
	public int getMaxSize(){ return maxSize; }
	
	public int getMaxY(){ return maxY; }
	
	public int getMinSize(){ return minSize; }
	
	public int getMinY(){ return minY; }
	
	public int getPosY(){ return SulvicMath.rangedInt(minY, maxY); }
	
	public int getPosY(Random rand){ return SulvicMath.rangedInt(rand, minY, maxY); }
	
	public int getVeinSize(){ return SulvicMath.rangedInt(minSize, maxSize); }
	
	public int getVeinSize(Random rand){ return SulvicMath.rangedInt(rand, minSize, maxSize); }
	
	public int getVeinChance(){ return veinChance; }
	
	public VeinData fullRange(){ return new VeinData(0, 255).setVeinSize(minSize, maxSize).setVeinChance(veinChance); }
	
}

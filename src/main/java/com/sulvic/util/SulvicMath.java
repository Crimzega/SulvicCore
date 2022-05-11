package com.sulvic.util;

import java.util.Random;

public class SulvicMath{
	
	private static final double ROTATION_BASE = Math.PI / 180d;
	private static final Random RAND = new Random();
	
	public static boolean inRange(byte value, byte min, byte max){ return value >= min && value < max; }
	
	public static boolean inRange(double value, double min, double max){ return value >= min && value < max; }
	
	public static boolean inRange(float value, float min, float max){ return value >= min && value < max; }
	
	public static boolean inRange(long value, long min, long max){ return value >= min && value < max; }
	
	public static boolean inRange(int value, int min, int max){ return value >= min && value < max; }
	
	public static boolean inRange(short value, short min, short max){ return value >= min && value < max; }
	
	public static byte clampByte(byte value, byte min, byte max){ return value < min? min: value > max? max: value; }
	
	public static byte maxByte(byte... values){ return SulvicCollections.sortedValues(values).get(values.length - 1); }
	
	public static byte minByte(byte... values){ return SulvicCollections.sortedValues(values).get(0); }
	
	public static byte rangedByte(Random rand, byte min, byte max){
		byte[] array = new byte[(max - min) + min];
		for(int i = 0; i < array.length; i++) array[i] = (byte)(min + (byte)i);
		return array[rand.nextInt(array.length)];
	}
	
	public static byte rangedByte(byte min, byte max){ return rangedByte(RAND, min, max); }
	
	public static byte wrapByte(byte value, byte min, byte max){ return (byte)((((value - min) % (max + (byte)1 - min)) + (max + (byte)1 - min)) % (max + (byte)1 - min) + min); }
	
	public static double clampDouble(double value, double min, double max){ return value < min? min: value > max? max: value; }
	
	public static double getRotationDouble(double value){ return ROTATION_BASE * clampDouble(value, -180d, 180d); }
	
	public static double minDouble(double... values){ return SulvicCollections.sortedValues(values).get(0); }
	
	public static double maxDouble(double... values){ return SulvicCollections.sortedValues(values).get(values.length - 1); }
	
	public static double rangedDouble(double min, double max){ return rangedDouble(RAND, min, max); }
	
	public static double rangedDouble(Random rand, double min, double max){ return rand.nextDouble() * (max - min) + min; }
	
	public static double wrapDouble(double value, double min, double max){ return (double)((((value - min) % (max + 1d - min)) + (max + 1d - min)) % (max + 1d - min) + min); }
	
	public static float getRotationFloat(float value){ return (float)ROTATION_BASE * clampFloat(value, -180f, 180f); }
	
	public static float clampFloat(float value, float min, float max){ return value < min? min: value > max? max: value; }
	
	public static float maxFloat(float... values){ return SulvicCollections.sortedValues(values).get(values.length - 1); }
	
	public static float minFloat(float... values){ return SulvicCollections.sortedValues(values).get(0); }
	
	public static float rangedFloat(float min, float max){ return rangedFloat(RAND, min, max); }
	
	public static float rangedFloat(Random rand, float min, float max){ return rand.nextFloat() * (max - min) + min; }
	
	public static float wrapFloat(float value, float min, float max){ return (float)((((value - min) % (max + 1f - min)) + (max + 1f - min)) % (max + 1f - min) + min); }
	
	public static long ceilDoubleAsLong(double value){
		long temp = (long)value;
		return value > (double)temp? temp + 1: temp;
	}
	
	public static long ceilFloatAsLong(float value){
		long temp = (long)value;
		return value > (float)temp? temp + 1: temp;
	}
	
	public static long clampLong(long value, long min, long max){ return value < min? min: value > max? max: value; }
	
	public static long floorDoubleAsLong(double value){
		long temp = (long)value;
		return value < (double)temp? temp - 1: temp;
	}
	
	public static long floorFloatAsLong(float value){
		long temp = (long)value;
		return value < (float)temp? temp - 1: temp;
	}
	
	public static long maxLong(long... values){ return SulvicCollections.sortedValues(values).get(values.length - 1); }
	
	public static long minLong(long... values){ return SulvicCollections.sortedValues(values).get(0); }
	
	public static long rangedLong(long min, long max){ return rangedLong(RAND, min, max); }
	
	public static long rangedLong(Random rand, long min, long max){ return rand.nextLong() * (max - min) + min; }
	
	public static long wrapLong(long value, long min, long max){ return (long)((((value - min) % (max + 1l - min)) + (max + 1l - min)) % (max + 1l - min) + min); }
	
	public static int ceilDoubleAsInt(double value){
		int temp = (int)value;
		return value > (double)temp? temp + 1: temp;
	}
	
	public static int ceilFloatAsInt(float value){
		int temp = (int)value;
		return value > (float)temp? temp + 1: temp;
	}
	
	public static int clampInt(int value, int min, int max){ return value < min? min: value > max? max: value; }
	
	public static int floorDoubleAsInt(double value){
		int temp = (int)value;
		return value < (double)temp? temp - 1: temp;
	}
	
	public static int floorFloatAsInt(float value){
		int temp = (int)value;
		return value < (float)temp? temp - 1: temp;
	}
	
	public static int maxInt(int... values){ return SulvicCollections.sortedValues(values).get(values.length - 1); }
	
	public static int minInt(int... values){ return SulvicCollections.sortedValues(values).get(0); }
	
	public static int rangedInt(int min, int max){ return rangedInt(RAND, min, max); }
	
	public static int rangedInt(Random rand, int min, int max){ return rand.nextInt(max - min) + min; }
	
	public static int wrapInt(int value, int min, int max){ return ((((value - min) % (max + 1 - min)) + (max + 1 - min)) % (max + 1 - min) + min); }
	
	public static short clampShort(short value, short min, short max){ return value < min? min: value > max? max: value; }
	
	public static short maxShort(short... values){ return SulvicCollections.sortedValues(values).get(values.length - 1); }
	
	public static short minShort(short... values){ return SulvicCollections.sortedValues(values).get(0); }
	
	public static short rangedShort(Random rand, short min, short max){
		short[] array = new short[(max - min) + min];
		for(int i = 0; i < max; i++) array[i] = (short)(min + (short)i);
		return array[rand.nextInt(array.length)];
	}
	
	public static short rangedShort(short min, short max){ return rangedShort(RAND, min, max); }
	
	public static short wrapShort(short value, short min, short max){ return (short)((((value - min) % (max + (short)1 - min)) + (max + (short)1 - min)) % (max + (short)1 - min) + min); }
	
}

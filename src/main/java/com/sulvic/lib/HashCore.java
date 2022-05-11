package com.sulvic.lib;

import java.util.Random;

@SuppressWarnings({"unused"})
public class HashCore {

	private static final Random RANDOM = new Random(0x15612e116abc50f8L);
	private final int initialOdd, multiplerOdd;
	private int finalHashCode;
	
	private HashCore(int initOdd, int multOdd) {
		finalHashCode = initialOdd = initOdd % 2 == 0? initOdd + (RANDOM.nextBoolean()? -1: 1): initOdd;
		multiplerOdd = multOdd % 2 == 0? multOdd + (RANDOM.nextBoolean()? -1: 1): multOdd;
	}

	public static HashCore create(int init, int mult){ return new HashCore(init, mult); }

	public HashCore append(Object obj) {
		finalHashCode = multiplerOdd * finalHashCode + (obj == null? 0: obj.hashCode());
		return this;
	}
	
	public int asHash(){ return finalHashCode; }

}

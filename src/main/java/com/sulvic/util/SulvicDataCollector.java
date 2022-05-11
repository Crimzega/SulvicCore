package com.sulvic.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressWarnings({"unchecked"})
public class SulvicDataCollector{
	
	private static Field getDeclaredField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{
		Class<?> objClass = obj.getClass();
		Field field = objClass.getDeclaredField(name);
		if(!field.isAccessible()) field.setAccessible(true);
		return field;
	}
	
	private static Field getDeclaredStaticField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{
		Field field = objClass.getDeclaredField(name);
		if(!field.isAccessible()) field.setAccessible(true);
		return field;
	}
	
	private static Field getField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{
		Class<?> objClass = obj.getClass();
		Field field = objClass.getField(name);
		if(!field.isAccessible()) field.setAccessible(true);
		return field;
	}
	
	private static Field getStaticField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{
		Field field = objClass.getField(name);
		if(!field.isAccessible()) field.setAccessible(true);
		return field;
	}
	
	private static Method getDeclaredMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException{
		Class<?> objClass = obj.getClass();
		Class<?>[] paramClasses = new Class<?>[params.length];
		for(int i = 0; i < params.length; i++) paramClasses[i] = params[i].getClass();
		Method method = objClass.getDeclaredMethod(name, paramClasses);
		if(!method.isAccessible()) method.setAccessible(true);
		return method;
	}
	
	private static Method getDeclaredStaticMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException{
		Class<?>[] paramClasses = new Class<?>[params.length];
		for(int i = 0; i < params.length; i++) paramClasses[i] = params[i].getClass();
		Method method = objClass.getDeclaredMethod(name, paramClasses);
		if(!method.isAccessible()) method.setAccessible(true);
		return method;
	}
	
	private static Method getMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException{
		Class<?> objClass = obj.getClass();
		Class<?>[] paramClasses = new Class<?>[params.length];
		for(int i = 0; i < params.length; i++) paramClasses[i] = params[i].getClass();
		Method method = objClass.getMethod(name, paramClasses);
		if(!method.isAccessible()) method.setAccessible(true);
		return method;
	}
	
	private static Method getStaticMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException{
		Class<?>[] paramClasses = new Class<?>[params.length];
		for(int i = 0; i < params.length; i++) paramClasses[i] = params[i].getClass();
		Method method = objClass.getMethod(name, paramClasses);
		if(!method.isAccessible()) method.setAccessible(true);
		return method;
	}
	
	public static <T> T getDeclaredGenericField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return (T)getDeclaredField(obj, name); }
	
	public static <T> T getDeclaredGenericMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return (T)getDeclaredObjectMethod(obj, name, params); }
	
	public static <T> T getDeclaredStaticGenericField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return (T)getDeclaredStaticObjectField(objClass, name); }
	
	public static <T> T getDeclaredStaticGenericMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return (T)getDeclaredStaticObjectMethod(objClass, name, params); }
	
	public static <T> T getGenericField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return (T)getObjectField(obj, name); }
	
	public static <T> T getGenericMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return (T)getObjectMethod(obj, name, params); }
	
	public static <T> T getStaticGenericField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return (T)getStaticObjectField(objClass, name); }
	
	public static <T> T getStaticGenericMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return (T)getStaticObjectMethod(objClass, name, params); }
	
	public static boolean getBooleanField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(obj, name).getBoolean(obj); }
	
	public static boolean getBooleanMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Boolean.parseBoolean(getStringMethod(obj, name, params)); }
	
	public static boolean getDeclaredBooleanField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(obj, name).getBoolean(obj); }
	
	public static boolean getDeclaredBooleanMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Boolean.parseBoolean(getDeclaredStringMethod(obj, name, params)); }
	
	public static boolean getStaticBooleanField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(objClass, name).getBoolean(objClass); }
	
	public static boolean getStaticBooleanMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Boolean.parseBoolean(getStringMethod(objClass, name, params)); }
	
	public static boolean getDeclaredStaticBooleanField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(objClass, name).getBoolean(objClass); }
	
	public static boolean getDeclaredStaticBooleanMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		return Boolean.parseBoolean(getDeclaredStaticStringMethod(objClass, name, params));
	}
	
	public static byte getByteField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(obj, name).getByte(obj); }
	
	public static byte getByteMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Byte.parseByte(getStringMethod(obj, name, params)); }
	
	public static byte getDeclaredByteField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(obj, name).getByte(obj); }
	
	public static byte getDeclaredByteMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Byte.parseByte(getDeclaredStringMethod(obj, name, params)); }
	
	public static byte getStaticByteField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(objClass, name).getByte(objClass); }
	
	public static byte getStaticByteMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Byte.parseByte(getStringMethod(objClass, name, params)); }
	
	public static byte getDeclaredStaticByteField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(objClass, name).getByte(objClass); }
	
	public static byte getDeclaredStaticByteMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		return Byte.parseByte(getDeclaredStaticStringMethod(objClass, name, params));
	}
	
	public static char getCharField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(obj, name).getChar(obj); }
	
	public static char getCharMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return getStringMethod(obj, name, params).charAt(0); }
	
	public static char getDeclaredCharField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(obj, name).getChar(obj); }
	
	public static char getDeclaredCharMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return getDeclaredStringMethod(obj, name, params).charAt(0); }
	
	public static char getStaticCharField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(objClass, name).getChar(objClass); }
	
	public static char getStaticCharMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return getStringMethod(objClass, name, params).charAt(0); }
	
	public static char getDeclaredStaticCharField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(objClass, name).getChar(objClass); }
	
	public static char getDeclaredStaticCharMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return getDeclaredStaticStringMethod(objClass, name, params).charAt(0); }
	
	public static double getDeclaredDoubleField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(obj, name).getDouble(obj); }
	
	public static double getDeclaredDoubleMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Double.parseDouble(getDeclaredStringMethod(obj, name, params)); }
	
	public static double getDoubleField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(obj, name).getDouble(obj); }
	
	public static double getDoubleMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Double.parseDouble(getStringMethod(obj, name, params)); }
	
	public static double getDeclaredStaticDoubleField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(objClass, name).getDouble(objClass); }
	
	public static double getDeclaredStaticDoubleMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		return Double.parseDouble(getDeclaredStaticStringMethod(objClass, name, params));
	}
	
	public static double getStaticDoubleField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(objClass, name).getDouble(objClass); }
	
	public static double getStaticDoubleMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Double.parseDouble(getStringMethod(objClass, name, params)); }
	
	public static float getDeclaredFloatField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(obj, name).getFloat(obj); }
	
	public static float getDeclaredFloatMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Float.parseFloat(getDeclaredStringMethod(obj, name, params)); }
	
	public static float getFloatField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(obj, name).getFloat(obj); }
	
	public static float getFloatMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Float.parseFloat(getStringMethod(obj, name, params)); }
	
	public static float getDeclaredStaticFloatField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(objClass, name).getFloat(objClass); }
	
	public static float getDeclaredStaticFloatMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		return Float.parseFloat(getDeclaredStaticStringMethod(objClass, name, params));
	}
	
	public static float getStaticFloatField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(objClass, name).getFloat(objClass); }
	
	public static float getStaticFloatMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Float.parseFloat(getStringMethod(objClass, name, params)); }
	
	public static int getDeclaredIntField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(obj, name).getInt(obj); }
	
	public static int getDeclaredIntMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Integer.parseInt(getDeclaredStringMethod(obj, name, params)); }
	
	public static int getIntField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(obj, name).getInt(obj); }
	
	public static int getIntMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Integer.parseInt(getStringMethod(obj, name, params)); }
	
	public static int getDeclaredStaticIntField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(objClass, name).getInt(objClass); }
	
	public static int getDeclaredStaticIntMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		return Integer.parseInt(getDeclaredStaticStringMethod(objClass, name, params));
	}
	
	public static int getStaticIntField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(objClass, name).getInt(objClass); }
	
	public static int getStaticIntMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Integer.parseInt(getStringMethod(objClass, name, params)); }
	
	public static Object getDeclaredObjectField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(obj, name).get(obj); }
	
	public static Object getDeclaredObjectMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return getDeclaredMethod(obj, name, params).invoke(obj, params); }
	
	public static Object getDeclaredStaticObjectField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredStaticField(objClass, name).get(objClass); }
	
	public static Object getDeclaredStaticObjectMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		return getDeclaredStaticMethod(objClass, name, params).invoke(objClass, params);
	}
	
	public static Object getObjectField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(obj, name).get(obj); }
	
	public static Object getObjectMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return getMethod(obj, name, params).invoke(obj, params); }
	
	public static Object getStaticObjectField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getStaticField(objClass, name).get(objClass); }
	
	public static Object getStaticObjectMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return getStaticMethod(objClass, name, params).invoke(objClass, params); }
	
	public static long getDeclaredLongField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(obj, name).getLong(obj); }
	
	public static long getDeclaredLongMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Long.parseLong(getDeclaredStringMethod(obj, name, params)); }
	
	public static long getLongField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(obj, name).getLong(obj); }
	
	public static long getLongMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Long.parseLong(getStringMethod(obj, name, params)); }
	
	public static long getDeclaredStaticLongField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(objClass, name).getLong(objClass); }
	
	public static long getDeclaredStaticLongMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		return Long.parseLong(getDeclaredStaticStringMethod(objClass, name, params));
	}
	
	public static long getStaticLongField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(objClass, name).getLong(objClass); }
	
	public static long getStaticLongMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Long.parseLong(getStringMethod(objClass, name, params)); }
	
	public static short getDeclaredShortField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(obj, name).getShort(obj); }
	
	public static short getDeclaredShortMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Short.parseShort(getDeclaredStringMethod(obj, name, params)); }
	
	public static short getShortField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(obj, name).getShort(obj); }
	
	public static short getShortMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Short.parseShort(getStringMethod(obj, name, params)); }
	
	public static short getDeclaredStaticShortField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredField(objClass, name).getShort(objClass); }
	
	public static short getDeclaredStaticShortMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		return Short.parseShort(getDeclaredStaticStringMethod(objClass, name, params));
	}
	
	public static short getStaticShortField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getField(objClass, name).getShort(objClass); }
	
	public static short getStaticShortMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return Short.parseShort(getStringMethod(objClass, name, params)); }
	
	public static String getDeclaredStringField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredObjectField(obj, name).toString(); }
	
	public static String getDeclaredStringMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return getDeclaredObjectMethod(obj, name, params).toString(); }
	
	public static String getDeclaredStaticStringField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getDeclaredStaticObjectField(objClass, name).toString(); }
	
	public static String getDeclaredStaticStringMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return getDeclaredStaticObjectMethod(objClass, name, params).toString(); }
	
	public static String getStringField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException{ return getObjectField(obj, name).toString(); }
	
	public static String getStringMethod(Object obj, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return getObjectMethod(obj, name, params).toString(); }
	
	public static String getStaticStringField(Class<?> objClass, String name) throws NoSuchFieldException, IllegalAccessException{ return getStaticObjectField(objClass, name).toString(); }
	
	public static String getStaticStringMethod(Class<?> objClass, String name, Object... params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{ return getStaticObjectMethod(objClass, name, params).toString(); }
	
}

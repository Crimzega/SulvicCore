package com.sulvic.core.proxy;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import cpw.mods.fml.relauncher.Side;

import cpw.mods.fml.relauncher.SideOnly;

@Retention(RUNTIME)
@Target({TYPE, FIELD, METHOD, CONSTRUCTOR})
@SideOnly(Side.CLIENT)
public @interface AlvontixServer{
	
}

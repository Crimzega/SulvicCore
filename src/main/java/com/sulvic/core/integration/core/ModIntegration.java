package com.sulvic.core.integration.core;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.*;

@Retention(RUNTIME)
@Target({TYPE})
public @interface ModIntegration{
	
	String[] value();
	
}

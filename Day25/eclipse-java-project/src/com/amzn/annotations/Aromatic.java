package com.amzn.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD,ElementType.CONSTRUCTOR })
@Retention(RetentionPolicy.RUNTIME)
public @interface Aromatic {
	public static int strength=10;

	String smell();
	String[] ingredients();
	
	int alcoholPercentage() default 5;
	
}

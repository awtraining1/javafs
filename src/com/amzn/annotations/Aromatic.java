package com.amzn.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface Aromatic {
	public static int strength=10;

	String smell();
	String[] ingredients();
	
	int alcoholPercentage() default 5;
	
}

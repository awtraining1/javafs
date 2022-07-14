package com.amzn.demo;

import java.lang.annotation.Annotation;

import com.amzn.fruits.Orange;

public class AnnotationsDemo {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		// Processing the annotation using reflection API.
		
		Class orangeClass = Orange.class;
		
		System.out.println("Annotations applied on a Orange class");
		Annotation[] annotationsOfOrangeClass = orangeClass.getAnnotations();		
		
		for(Annotation Anno: annotationsOfOrangeClass) {			
			System.out.println(Anno.toString());			
		}
		
		// Find all annotations of makeJuice method inside Orange class
		System.out.println("Annotations applied on makeJuice Method");
		Annotation[] annotationsOfOrangeClassMakeJuiceMethod =
				orangeClass.getMethod("makeJuice").getAnnotations();
		
		for(Annotation Anno: annotationsOfOrangeClassMakeJuiceMethod) {			
			System.out.println(Anno.toString());			
		}

	}

}

package com.amzn.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import com.amzn.people.Retailer;

class MyClass {
	private int age;
	public String name;

	public MyClass() {

	}

	public MyClass(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	 

}

public class ReflectionAPIDemo {

	public static void main(String[] args) {
		Class class1 = Retailer.class;

		System.out.println("Class name:" + class1.getName());
		System.out.println("");
		;
		Field[] feildsOfMyClass = class1.getDeclaredFields();

		System.out.println("\nFEILD INFO");
		for (Field f : feildsOfMyClass) {
			String str = String.format("name: %s of type: %s. Access-modifier:%s", f.getName(), f.getType(),
					f.getModifiers());
			System.out.println(str);
		}

		// 21A - Write a class that has 2 fields of different types.
		// Use reflection API to print the field information.
		
		System.out.println("\nConstructor INFO");
		Constructor[] allConstructorsOfMyClass = class1.getDeclaredConstructors();
		for (Constructor constructor : allConstructorsOfMyClass) {
			String str = String
					.format("Name:%s, Arguments:%s",constructor.getName(),
							Arrays.toString(constructor.getParameters()) );
			System.out.println(str);			
		};
		
		System.out.println("\nMethod INFO");
		Method[] allMethodsOfMyClass = class1.getDeclaredMethods();
		for(Method method: allMethodsOfMyClass) {
			String str = String
					.format("Name:%s, Arguments:%s , Return-Type:%s ",method.getName(),
							Arrays.toString(method.getParameters()), method.getReturnType() );
			System.out.println(str);
		}

	}

}

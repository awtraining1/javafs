package com.amzn.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import com.amzn.people.Retailer;

class MyClass {
	private int age=76;
	 String name;

	public MyClass() {

	}

	public MyClass(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String method1() {
		return "Hello";
	}
	
	private String method2(int i) {
		return "Here is a top secret no "+i;
	}
	
	private String method3(int i, float f, String s) {
		return "Here is a top secret no "+ i + f +  s;
	}
	
	public int getAge() {
		return this.age;
	}

}


public class ReflectionAPIDemo {

	//
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		Class class1 = MyClass.class;

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
		System.out.printf("Total methods: %s \n",allMethodsOfMyClass.length);
		for(Method method: allMethodsOfMyClass) {
			String str = String
					.format("Name:%s, Arguments:%s , Return-Type:%s ",method.getName(),
							Arrays.toString(method.getParameters()), method.getReturnType() );
			System.out.println(str);
			
			// Invoke the method (with any access type - public,private,default or protected.
			if(method.getName().equals("method2")) {
				method.setAccessible(true);// method2 will be public temporarily
				String result = (String) method.invoke(class1.newInstance(), 25);
				System.out.println("result="+result);
			}
		};
		
		// 21B - Use reflection API to print the field,constructor and method information.
		// of any class in your project.
		
		//Once we have the object representing any class like above (class1)
		
		System.out.println("\nCreating object from ");
		MyClass myClass1=null;
		try {
			myClass1 = (MyClass) class1.newInstance();
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		System.out.println(myClass1.method1());
		
		//System.out.println(myClass1.method2(5)); // won't compile because method2 is private
		
		// Invoking methods (applicable to private methods also) 
		// approach 2 - by getting a direct reference to the particular method.
		Method method2Ref = class1.getDeclaredMethod("method3", int.class, float.class, String.class );
		method2Ref.setAccessible(true); // relax the private access restriction
		String result = (String) method2Ref.invoke(class1.newInstance(), 25, 3.25f, "World");
		System.out.println("approach 2 result="+result);
		
		
		// Accessing private member variable and changing their value;
		System.out.println("myClass1 age before ="+myClass1.getAge());
		
		Field ageFeild = class1.getDeclaredField("age");
		ageFeild.setAccessible(true);
		ageFeild.setInt(myClass1, 1000);
		
		System.out.println("myClass1 age after ="+myClass1.getAge());		
	}

}

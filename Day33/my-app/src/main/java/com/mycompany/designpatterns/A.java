package com.mycompany.designpatterns;

// Singleton Pattern implementation
public class A {
public static A aObj = null;

	private A() {
	}
	public static A createInstance() {
		if (aObj == null)
			aObj = new A();

		return aObj;
	}

}
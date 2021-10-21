package com.java8.inter;

@FunctionalInterface
public interface MyInterface2 {

	public static int num = 100;
	public void setNm();

	public default void display() {
		System.out.println("display method of MyInterface2");
	}
	
	static void staticMeth() {
		System.out.println("I am Static2 Method");
	}
}

package com.java8.inter;

public class InterfaceExample implements MyInterface,MyInterface2 {
	
	public void display() {
		System.out.println("Overriden display method of class");
		MyInterface.super.display();
		MyInterface2.super.display();
	}

	public static void main(String args[]) {
		InterfaceExample obj = new InterfaceExample();
		obj.display();
		MyInterface.staticMeth();
		MyInterface2.staticMeth();
		
	}

	@Override
	public void setNm() {
		// TODO Auto-generated method stub
		
	}
}

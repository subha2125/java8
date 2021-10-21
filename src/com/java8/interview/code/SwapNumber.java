package com.java8.interview.code;

public class SwapNumber {

	public static void main(String[] args) {
		int a = 10;
		int b = 30;
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.printf("a is %d, b is %d", a, b); //
		
		String s = "Hello";
		String y = "Kolkata";
		s = s.concat(y);
		y = s.substring(0, y.length()-2);
		s = s.substring(y.length());
		System.out.println("\n\n");
		System.out.println("S= " + s + " y="+y);
				

	}

}

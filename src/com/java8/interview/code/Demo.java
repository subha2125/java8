package com.java8.interview.code;

class Demo1

{
	int add(int a, int b) {
		return a + b;
	}

	int add(int a, int b, int c) {
		return 890;
	}
	int add(int a, long b, int c) {
		return 89;
	}
}

public class Demo {
	public static void main(String args[]) {
		Demo1 obj = new Demo1();
		System.out.println(obj.add(10, 20));
		System.out.println(obj.add(10, 20, 30));
	}
}

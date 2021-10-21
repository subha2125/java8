package com.java7;

import java.util.Arrays;
import java.util.WeakHashMap;

public class WeakHashMapExample {

	public static void main(String[] args) {
		WeakHashMap<Student,Integer> wm = new WeakHashMap<>();
		Student s1= new Student(3, "Yes Papa");
		wm.put(new Student(1, "John"), 1);
		wm.put(new Student(2, "Roby"), 2);
		wm.put(s1, 3);
		
		System.out.println("Size.."+wm.size());
		
		s1=null;
		System.gc();
		System.out.println("\nAfter GC Size.."+wm.size());
		
		int[] a= {1,67,34,89,76,99,23};
		Arrays.sort(a);
		System.out.println(a[a.length-2]);

	}
	
	protected void finalzer() {
		System.out.println("GC Runing");
	}

}

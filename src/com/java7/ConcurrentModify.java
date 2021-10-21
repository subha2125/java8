package com.java7;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModify {

	public static void main(String[] args) {
		List<String> sList = new CopyOnWriteArrayList<>();
		sList.add("Subhadip");
		sList.add("Java");
		
		Iterator<String> i = sList.iterator();
		while(i.hasNext()) {
		
			sList.add("1");
			System.out.println(i.next());
		}

		sList.stream().forEach(System.out::println);
	}

}

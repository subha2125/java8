package com.java8.interview.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCode {

	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		List<Integer> duplicate = Arrays.asList(10, 15, 8, 49, 25, 98, 32, 56, 32, 15);
		// Find All Even
		myList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()).forEach(s -> System.out.print(s + ","));

		System.out.println("\nAfter Remove Duplicate");
		duplicate.stream().distinct().collect(Collectors.toList()).forEach(s -> System.out.print(s + ","));

		System.out.println("\nNumber Start With 1");
		myList.stream().map(s -> String.valueOf(s)).filter(s -> s.startsWith("1")).collect(Collectors.toList())
				.forEach(s -> System.out.print(s + ","));

		System.out.println("\nFirst Element of List");
		myList.stream().findFirst().ifPresent(System.out::println);

		int max = myList.stream().max(Integer::compare).get();
		System.out.println(max);
		
		myList.sort((i1,i2) -> i2.compareTo(i1));
		System.out.println(myList.get(0));
		
		 List<Integer> myListdd = Arrays.asList(10,15,8,49,25,98,98,32,15);

		 myListdd.stream()
               .sorted()
               .forEach(System.out::println);
		
	}

}

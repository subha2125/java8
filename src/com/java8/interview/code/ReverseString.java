package com.java8.interview.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ReverseString {

	public static void main(String[] args) {
		Function<String, String> reverse = s -> new StringBuilder(s).reverse().toString();
		System.out.println(reverse.apply("Gonchu"));

		Predicate<String> p = s -> s.contains("LoveU");
		System.out.println(p.test("I LoveU"));

		/*
		 * duplicateChars("ABCGBKAA"); removeDuplicateChars("ABCGBKAA");
		 */

		List<String> duplicateString = Arrays.asList("ABCGBKAACCCHHHIIIXZ".split(""));
		Set<String> set = new HashSet<>();
		Set<String> set1 = new HashSet<>();
		
		Set<String> duplicate = duplicateString.stream().filter(x -> !set.add(x)).collect(Collectors.toSet());
		System.out.println("Set of Duplicate String" + duplicate);
		
		Set<String> unique = duplicateString.stream().filter(x -> set1.add(x)).collect(Collectors.toSet());
		System.out.println("Set of Original String" + unique);

	}

	public static final void duplicateChars(String input) {
		char[] charString = input.toCharArray();
		Set setDuplicated = new HashSet<>();
		Set distinctChars = new HashSet<>();
		for (char c : charString) {
			if (!distinctChars.add(c)) {
				setDuplicated.add(c);
			}
		}
		setDuplicated.forEach(ch -> System.out.print(ch + " "));

	}

	public static final void removeDuplicateChars(String input) {
		char[] charString = input.toCharArray();
		Set setDuplicated = new HashSet<>();
		Set distinctChars = new HashSet<>();
		for (char c : charString) {
			if (!distinctChars.add(c)) {
				setDuplicated.add(c);
			}
		}
		String s = (String) distinctChars.stream().collect(Collectors.joining());
		System.out.println("After removing Duplicate" + s);

	}

}

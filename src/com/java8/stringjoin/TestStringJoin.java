package com.java8.stringjoin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStringJoin {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("life insurance", "health insurance", "car insurance");
		System.out.println(String.join(",", list));
		String fromStream = list.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
		System.out.println(fromStream);
		list.stream().sorted().forEach(x -> System.out.println(x));
	}

}

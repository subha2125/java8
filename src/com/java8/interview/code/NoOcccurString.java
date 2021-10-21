package com.java8.interview.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NoOcccurString {

	public static void main(String[] args) {
		String occurance= "Welcome to Java8 Programs Welcome agian Java8 Coding test Done test Java8";
		List<String> occrList = Arrays.asList(occurance.split(" "));
		
		Map<String,Long> map = occrList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);
		
		Function<String,String> f = Function.identity();
		System.out.println(f.apply("\n\n\nHello"));
		
		Set<String> distinct = new HashSet<>();
		Set<String> sDis = occrList.stream().filter(s -> !distinct.add(s)).collect(Collectors.toSet());
		
		Map<String,Long> distincMap = sDis.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(distincMap);
		
		distincMap.computeIfAbsent("test1", x -> Long.sum(20l, 10l));
		System.out.println(distincMap);
		
		distincMap.computeIfPresent("test", (x,y) -> Long.sum(29l, 10l));
		System.out.println(distincMap);
	}

	
	
}

package com.java8.interview.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EliminateDuplicate {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("1","2","6","1","2","9","15","67","98","98","67","56","45","98","2");
		
		list.stream().skip(5).forEach(x -> System.out.println(x));
		System.out.println("\n\n");
		Set<String> set = new HashSet<>();
		list.stream().filter(s -> !set.add(s)).collect(Collectors.toSet()).forEach(x -> System.out.println(x));

		System.out.println("\n\n");
		list.stream().skip(3).limit(8).forEach(x -> System.out.println(x));
		
		String s = "Subhadip";
		s = s.concat("ww");
		System.out.println(s);
		
	}

}

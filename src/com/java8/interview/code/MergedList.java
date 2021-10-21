package com.java8.interview.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergedList {

	public static void main(String[] args) {
		List<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        
        List<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "f", "g"));
         
        List<String> combinedList = Stream.of(listOne, listTwo)
                                        .flatMap(x -> x.stream())
                                        .collect(Collectors.toList());
        System.out.println(combinedList);

	}

}

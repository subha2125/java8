package com.java8.mapreduce;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapReduceExample {


	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);

		List<String> words = Arrays.asList("corejava", "spring", "hibernate");

		String join = String.join(",", words);

		System.out.println(join);

		int sum = 0;
		for (int no : numbers) {
			sum = sum + no;
		}
		System.out.println(sum);

		int sum1 = numbers.stream().mapToInt(i -> i).sum();
		System.out.println(sum1);

		Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
		System.out.println("Reduce Sum.." + reduceSum);

		Optional<Integer> reduceSumWithMethodReference = numbers.stream().reduce(Integer::sum);
		System.out.println(reduceSumWithMethodReference.get());

		Integer mulResult = numbers.stream().reduce(1, (a, b) -> a * b);
		System.out.println(mulResult);

		Integer maxvalue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
		System.out.println("MaxValue.." + maxvalue);

		Integer maxvalueWithMethodReference = numbers.stream().reduce(Integer::max).get();
		System.out.println(maxvalueWithMethodReference);

		String longestString = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
				.get();
		System.out.println("LongestString.." + longestString);

		// get employee whose grade A
		// get salary
		double avgSalary = EmployeeDatabase.getEmployees().stream()
				.filter(employee -> employee.getGrade().equalsIgnoreCase("A")).map(employee -> employee.getSalary())
				.mapToDouble(i -> i).average().getAsDouble();

		System.out.println(avgSalary);

		double sumSalary = EmployeeDatabase.getEmployees().stream()
				.filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
				// .map(employee -> employee.getSalary())
				.mapToDouble(i -> i.getSalary()).sum();
		System.out.println("SumSalary:" + sumSalary);

		Map<String, List<String>> people = new HashMap<>();
		people.put("John", Arrays.asList("555-1123", "555-3389"));
		people.put("Mary", Arrays.asList("555-2243", "555-5264"));
		people.put("Steve", Arrays.asList("555-6654", "555-3242"));
		List<String> phones = people.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println("phones:" + phones);

		people.entrySet().stream().sorted(Map.Entry.comparingByKey());
		System.out.println("Sorted people:" + people);

	}
}

package com.java8.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortMapDemo {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("eight", 8);
		map.put("four", 4);
		map.put("ten", 10);
		map.put("two", 2);
		
		map.putIfAbsent("t", 1);
		map.computeIfAbsent("ii", k -> 1);
		

		Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()));
		employeeMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
		employeeMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 90);
		employeeMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);
		employeeMap.put(new Employee(624, "Sourav", "CORE", 400000), 40);
		employeeMap.put(new Employee(284, "Prakash", "SOCIAL", 1200000), 120);
		
		// Classcast
		/*Map<Student, Integer> sMap = new TreeMap<>();
		sMap.put(new Student(176, "Roshan", "IT", 600000), 60);
		for(Map.Entry<Student, Integer> entry : sMap.entrySet()) {
			System.out.println("Key.."+entry.getKey() + "values.."+entry.getValue());
		}*/

		System.out.println(employeeMap);
		
		for(Map.Entry<Employee, Integer> entry : employeeMap.entrySet()) {
			System.out.println("Key.."+entry.getKey() + "values.."+entry.getValue());
		}

		List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));

		/*
		 * for (Entry<String, Integer> entry : entries) {
		 * System.out.println(entry.getKey() + "   " + entry.getValue()); }
		 */

		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		System.out.println("\n****************************\n\n");
		
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		System.out.println("\n****************************\n");
		employeeMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getDept).reversed()))
				.forEach(emp -> System.out.println("Employee Sorted With Dept.."+emp));
		
		System.out.println("\n****************************");

		
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
		.forEach(emp -> System.out.println("Employee Sorted With Values.."+emp));
		
	}
}

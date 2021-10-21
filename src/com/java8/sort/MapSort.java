package com.java8.sort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapSort {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("eight", 8);
		map.put("four", 4);
		map.put("ten", 10);
		map.put("two", 2);
		
		map.entrySet().stream().sorted(Map.Entry.comparingByKey());
		
		List<Employee> employees = DataBase.getEmployees();	
		
		employees.stream().sorted((e1,e2) -> e1.getName().compareTo(e2.getName()));
		
		employees.stream()
		.filter(e -> !e.getName().equals("Roshan"))
		.mapToDouble( e -> e.getSalary()).average().getAsDouble();
		
		for(Map.Entry<String, Integer> m : map.entrySet() ) {
			System.out.println(m.getValue()+m.getKey());
		}
		
		map.forEach((k,v) -> System.out.println("Key:"+k+"value:"+v));
		
	}

}

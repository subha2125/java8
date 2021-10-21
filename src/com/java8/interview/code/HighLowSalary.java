package com.java8.interview.code;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java8.mapreduce.Employee;
import com.java8.mapreduce.EmployeeDatabase;

public class HighLowSalary {

	public static void main(String[] args) {
		List<Employee> allEmployees = EmployeeDatabase.getEmployees();
		
		Map<Object, Object> topEmployees =
			    allEmployees.stream()
			    .collect(groupingBy(
			                    e -> e.getSalary(),
			                    collectingAndThen(maxBy(comparingDouble(e -> e.getSalary())), Optional::get) 
			                ));
		
		Employee e = allEmployees.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get();
		System.out.print(e.getName()+e.getSalary());
		
		
		Employee lowE = allEmployees.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getSalary))).get();
		System.out.print(lowE.getName()+lowE.getSalary());
		
	}

}

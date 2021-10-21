package com.java8.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortListDemo {

	public static void main(String[] args) {
		List<Employee> employees = DataBase.getEmployees();	

		employees.stream().sorted(Comparator.comparing(Employee::getDept)).
		   forEach(x -> System.out.println("Sort By Department" + x));
		
		Comparator<Employee> comparator = new Comparator<Employee>() {
			
			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		};
		
		employees.stream().sorted(comparator).forEach(x -> System.out.println("Sort By name" + x));
		
		employees.stream().sorted(( o1, o2) -> o1.getName().compareTo(o2.getName()));
		
		employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(e -> System.out.println(e));
		
		Optional p = Optional.ofNullable(null);
		
		System.out.println(p);
		
		Stream<String> fruitsStream = Stream.of("Banana", "Apple", "Orange", "Apple", "Grapes");
		int count = fruitsStream.distinct().sorted().collect(Collectors.toList()).size();
		//System.out.println(count);		
	}

}

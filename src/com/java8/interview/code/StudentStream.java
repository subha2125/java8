package com.java8.interview.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentStream {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("Roshan", 19));
		list.add(new Student("Komal", 40));
		list.add(new Student("Bimal", 26));
		list.add(new Student("Bikash", 20));
		list.add(new Student("Sourav", 30));
		list.add(new Student("Prakash", 32));
		list.add(new Student("Roshan", 27));
		list.add(new Student("Sourav", 34));

		list.stream()
		.filter(s -> s.getAge() > 25)
		.map(Student::getName).forEach(System.out::println);

		long count = list.stream().filter(s -> s.getAge() > 25).count();
		System.out.println(count);

		Optional<Student> student = list.stream().filter(e -> e.getName().equalsIgnoreCase("Mary")).findAny();

		System.out.println(student.isPresent() ? student.get() : "Default");

		OptionalInt max = list.stream().mapToInt(Student::getAge).max();
		System.out.println(max.isPresent() ? max.getAsInt() : "0");
		
		System.out.println("\n**********");
		
		//Given a list of employees, sort all the employee on the basis of age? Use java 8 APIs only
		list.stream().sorted((s1, s2) -> (int) (s1.getAge() - s2.getAge()))
				.forEach(s -> System.out.println("Sort ByAge = " + s.getName()));
		
		System.out.println("\n**********");
		
		//Join the all employee names with “,” using java 8?
		String EmpName = list.stream().map(s -> s.getName()).collect(Collectors.joining(","));
		System.out.println("EmpName="+EmpName);
		
		 //Given the list of employee, group them by employee name?
		
		Map<String,Long> empGrPMap  = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
		System.out.println("\n**********");
		for(Map.Entry<String,Long> m : empGrPMap.entrySet()) {
			System.out.println("Value..."+ m.getValue() + "  Key.."+  m.getKey());
		}
		
		// Sort Map By Keys
		System.out.println("\nSort By keys **********\n");
		empGrPMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((y) -> System.out.println(y));
		
		BiFunction<String,String, String> bf = (x,y) -> x.concat(y);
		bf.apply("s", "u");
		System.out.println(bf.apply("s", "u"));
		
		Function<String,String> bf1 = y -> y.concat("Subha");
		System.out.println(bf1.apply("s"));
	}

}

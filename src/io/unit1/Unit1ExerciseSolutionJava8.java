package io.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import io.common.Person;

public class Unit1ExerciseSolutionJava8 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);
		
		// Step 1: Sort list by last name
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		// Step 2: Create a method that prints all elements in the list
		System.out.println("Printing all persons");
		printConditionally(people, p -> true);
		
		Predicate<Person> pd = p -> p.getFirstName().startsWith("S");
		Consumer<String> cs = p -> System.out.println(p);
		Supplier<String> sp = () -> "Hello";
		cs.accept("Hello World");
		System.out.println(sp.get());
		
		// Step 3: Create a method that prints all people that have last name beginning with C
		System.out.println("Printing all persons with last name beginning with C");
		printConditionally(people, p -> p.getLastName().startsWith("C"));

		System.out.println("Printing all persons with first name beginning with C");
		
		printConditionally(people, p -> p.getFirstName().startsWith("C"));
		
		printConditionallyPredicate(people, p -> ((Person) p).getFirstName().startsWith("C"));
		
	}

	private static void printConditionally(List<Person> people, Condition condition) {
		for (Person p : people) {
			if (condition.test(p)) {
				System.out.println(p);
			}
		}
	}
	
	private static void printConditionallyPredicate(List<Person> people, Predicate predicate) {
		for (Person p : people) {
			if (predicate.test(p)) {
				System.out.println("With predicate >>> " + p);
			}
		}
	}

	
	
}


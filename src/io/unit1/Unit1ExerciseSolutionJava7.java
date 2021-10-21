package io.unit1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.common.Person;

public class Unit1ExerciseSolutionJava7 {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>(Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)));
		people.add(new Person("Rohit", "Goyal", 30));

		// Step 1: Sort list by last name
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});

		
		Flower flower = new Flower() {
			
			@Override
			public Double getPrice() {
				// TODO Auto-generated method stub
				return 23.9;
			}
			
			@Override
			public String getColor() {
				// TODO Auto-generated method stub
				return "White";
			}
		};
		System.out.println("Flower Color... " +flower.getColor() + ",Flower Price... " + flower.getPrice() +"\n");
		// Step 2: Create a method that prints all elements in the list
		System.out.println("Printing all persons\n");
		printAll(people);

		// Step 3: Create a method that prints all people that have last name beginning
		// with C
		System.out.println("\n\nPrinting all persons with last name beginning with C\n\n");
		printConditionally(people, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("C");
			}
		});

		System.out.println("\nGet Last Name only with last name beginning with C\n\n");
		printConditionallyLastName(people, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("C");
			}
		}, new LastName() {

			@Override
			public String getLastName(Person p) {
				return p.getLastName();
			}
		});

		System.out.println("\n\nPrinting all persons with first name beginning with C\n");
		printConditionally(people, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.getFirstName().startsWith("C");
			}
		});

	}

	private static void printConditionally(List<Person> people, Condition condition) {
		for (Person p : people) {
			if (condition.test(p)) {
				System.out.println(p);
			}
		}
	}

	private static void printConditionallyLastName(List<Person> people, Condition condition, LastName lastName) {
		for (Person p : people) {
			if (condition.test(p)) {
				System.out.println(lastName.getLastName(p));
			}
		}
	}

	private static void printAll(List<Person> people) {
		for (Person p : people) {
			System.out.println(p);
		}
	}
}

interface Condition {
	boolean test(Person p);
}

interface LastName {
	String getLastName(Person p);
}

interface Flower{
	String getColor();
	Double getPrice();
}

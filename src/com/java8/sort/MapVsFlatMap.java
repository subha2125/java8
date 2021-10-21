package com.java8.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapVsFlatMap {
	public static void main(String[] args) {

		List<Customer> customers = EkartDataBase.getAll();
		
		List<String> names = customers.stream().filter(cus -> cus.getEmail().equalsIgnoreCase("smith@gmail.com"))
				.map(cus -> cus.getName())
				.collect(Collectors.toList());
		
		Optional<String> name = customers.stream().filter(cus -> cus.getEmail().equalsIgnoreCase("smith@gmail.com"))
				.map(cus -> cus.getName()).findAny();
		
		System.out.println("Names..."+names);
		System.out.println("Names..."+name.get());
		
		customers.stream().filter(cus -> cus.getEmail().equalsIgnoreCase("kely@gmail.com"))
		.map(cus -> cus.getName()).forEach(s -> System.out.println(s));
		
		Collections.sort(customers, (o1, o2) ->(int) (o1.getId() - o2.getId()));

		// List<Customer> convert List<String> -> Data Transformation
		// mapping : customer -> customer.getEmail()
		// customer -> customer.getEmail() one to one mapping
		List<String> emails = customers.stream().map(customer -> customer.getEmail()).collect(Collectors.toList());
		System.out.println("Collection Email.."+emails);

		// customer -> customer.getPhoneNumbers() ->> one to many mapping
		// customer -> customer.getPhoneNumbers() ->> one to many mapping
		List<List<String>> phoneNumbers = customers.stream()
				.map(customer -> customer.getPhoneNumbers())
				.collect(Collectors.toList());
		System.out.println("Collection Phone Numbers.."+phoneNumbers);
		
		List<String> flatphoneNumbers = customers.stream()
				.flatMap(customer -> customer.getPhoneNumbers().stream())
				.collect(Collectors.toList());
		System.out.println("Collection Phone flatphoneNumbers Numbers.."+flatphoneNumbers);
		
		
		List<List<String>> johnPhoneNumber = customers.stream()
				.filter(customer -> customer.getName().startsWith("john"))
				.map(customer -> customer.getPhoneNumbers())
				.peek(System.out::println)
			    .collect(Collectors.toList());
		System.out.println("\nJohn Number Without FlatMap.."+johnPhoneNumber);
		
		
		
		 customers.stream()
				.filter(customer -> customer.getName().startsWith("john"))
				.flatMap(customer -> customer.getPhoneNumbers().stream())
				.peek(System.out::println).forEach(phone -> System.out.println("Phone Number.."+phone));;
			    
		System.out.println("\n\nJohn Number After Faltmap.."+johnPhoneNumber);

		// List<Customer> convert List<String> -> Data Transformation
		// mapping : customer -> phone Numbers
		// customer -> customer.getPhoneNumbers() ->> one to many mapping
		List<String> phones = customers.stream()
				  .filter(customer -> customer.getEmail().equals("john@gmail.com"))
				  .flatMap(customer -> customer.getPhoneNumbers().stream())
				.collect(Collectors.toList());
		System.out.println("\nPhoness"+phones);
		
		
		customers.stream()
		  .filter(customer -> customer.getEmail().equals("john@gmail.com"))
		  .flatMap(customer -> customer.getPhoneNumbers().stream())
		  .forEach(phone -> System.out.println("Phone.." + phone));
		
		System.out.println("\n\n Peek \n");
		customers.stream()
		.filter(customer -> !customer.getName().startsWith("john"))
		.peek(System.out::println)
		/*.skip(1).limit(2)*/
		.map(customer -> customer.getPhoneNumbers())
		.forEach(System.out::println);
		
		
	}
}

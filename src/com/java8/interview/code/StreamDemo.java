package com.java8.interview.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import sun.security.x509.IssuingDistributionPointExtension;

public class StreamDemo {
	static List<Resource> resourceList = new ArrayList<Resource>();

	public static void main(String[] args) {

		resourceList.add(new Resource(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		resourceList.add(new Resource(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		resourceList.add(new Resource(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		resourceList.add(new Resource(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		resourceList.add(new Resource(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		resourceList.add(new Resource(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		resourceList.add(new Resource(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		resourceList.add(new Resource(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		resourceList.add(new Resource(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		resourceList.add(new Resource(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		resourceList.add(new Resource(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		resourceList.add(new Resource(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		resourceList.add(new Resource(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		resourceList.add(new Resource(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		resourceList.add(new Resource(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		resourceList.add(new Resource(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		resourceList.add(new Resource(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		resourceList.add(new Resource(277, "kamol Patidar", 39, "Female", "Product Development", 2017, 1235700.0));
		resourceList.add(new Resource(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// Query 1 : How many male and female Resources are there in the organization?
		method1();
		System.out.println("\n");
		// Query 2 : Print the name of all departments in the organization?
		method2();
		System.out.println("\n");
		// Query 3 : What is the average age of male and female employees?
		method3();
		System.out.println("\n");
		// Query 4 : Get the details of highest paid employee in the organization?
		method4();
		System.out.println("\n");
		// Query 5 : Get the names of all employees who have joined after 2015?
		method5();
		System.out.println("\n");
		// Query 6 : Count the number of employees in each department?
		System.out.println("\n");
		method6();
		System.out.println("\n");
		// Query 10 : How many male and female employees are there in the sales and
		// marketing team?
		method10();
		System.out.println("\n");
		// Query 11 : What is the average salary of male and female employees?
		method11();
		// Query 13 : What is the average salary and total salary of the whole
		// organization?
		method13();
	}

	public static void method1() {
		System.out.println("Query 1 : How many male and female Resources are there in the organization?");
		Map<String, Long> noOfMaleAndFemaleEmployees = resourceList.stream()
				.collect(Collectors.groupingBy(Resource::getGender, Collectors.counting()));
		for (Map.Entry<String, Long> e : noOfMaleAndFemaleEmployees.entrySet()) {
			System.out.println("Gender: " + e.getKey() + "  Count: " + e.getValue());
		}
		
		System.out.println("Size EMployee.."+ resourceList.size());
		System.out.println("Distinct EMployee.."+ resourceList.stream().distinct().count());
	}

	public static void method2() {
		System.out.println("Query 2 : Print the name of all departments in the organization?");
		resourceList.stream().map(Resource::getDepartment).distinct().forEach(System.out::println);

		Function<String, String> fc = x -> x.concat("hello");
		fc.apply("Subhadip");
	}

	public static void method3() {
		// Query 3 : What is the average age of male and female employees?
		Map<String, Double> m = resourceList.stream()
				.collect(Collectors.groupingBy(Resource::getGender, Collectors.averagingInt(Resource::getAge)));
		for (Map.Entry<String, Double> e : m.entrySet()) {
			System.out.println("Gender: " + e.getKey() + "  Avg Salary: " + e.getValue());
		}
	}

	public static void method4() {
		// Query 4 : Get the details of highest paid employee in the organization?

		Double max = resourceList.stream().mapToDouble(Resource::getSalary).max().getAsDouble();
		System.out.println("Highest Salary = " + max);

		Optional<Resource> rs = resourceList.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Resource::getSalary)));
		System.out.println("Highest Res details = " + rs.get());
	}

	public static void method5() {
		resourceList.stream().filter(e -> e.getYearOfJoining() > 2015).collect(Collectors.toList())
				.forEach(x -> System.out.println(x));
	}

	public static void method6() {
		Map<String, Long> m = resourceList.stream()
				.collect(Collectors.groupingBy(Resource::getDepartment, Collectors.counting()));

		Map<String, Long> m2 = resourceList.stream()
				.collect(Collectors.groupingBy(res -> res.getDepartment(), Collectors.counting()));

		for (Map.Entry<String, Long> e : m.entrySet()) {
			System.out.println("Dept: " + e.getKey() + "  Count: " + e.getValue());
		}

		Map<String, Double> m1 = resourceList.stream().collect(
				Collectors.groupingBy(Resource::getDepartment, Collectors.averagingDouble(Resource::getSalary)));

		System.out.println("\n\n");
		for (Map.Entry<String, Double> e : m1.entrySet()) {
			System.out.println("Dept: " + e.getKey() + "  Avg Salary: " + e.getValue());
		}
	}

	public static void method10() {
		Map<String, Long> m = resourceList.stream().filter(e -> e.getDepartment().equals("Sales And Marketing"))
				.collect(Collectors.groupingBy(Resource::getGender, Collectors.counting()));
		for (Map.Entry entry : m.entrySet()) {
			System.out.println("Gender " + entry.getKey() + " Count:" + entry.getValue());
		}
	}

	public static void method11() {
		// Query 11 : What is the average salary of male and female employees?
		Map<String, Double> m = resourceList.stream()
				.collect(Collectors.groupingBy(Resource::getGender, Collectors.averagingDouble(Resource::getSalary)));
		for (Map.Entry entry : m.entrySet()) {
			System.out.println("Gender " + entry.getKey() + " Avg Salary:" + entry.getValue());
		}
	}
	
	// Query 13 : What is the average salary and total salary of the whole
			// organization?
	public static void method13() {
		Double avgSalary = resourceList.stream().mapToDouble(Resource::getSalary).average().getAsDouble();
		Double totalSalary = resourceList.stream().mapToDouble(Resource::getSalary).sum();
		Double maxSalary = resourceList.stream().mapToDouble(Resource::getSalary).max().getAsDouble();
		Optional<Resource> res= resourceList.stream().collect(Collectors.maxBy(Comparator.comparing(Resource::getSalary)));
		
		resourceList.stream().sorted(Comparator.comparing(Resource::getSalary));
		resourceList.sort(Comparator.comparing(Resource::getSalary));
		resourceList.sort((r1,r2) -> r1.getDepartment().compareTo(r2.getDepartment()));
	}
}

class Resource {
	int id;

	String name;

	int age;

	String gender;

	String department;

	int yearOfJoining;

	double salary;

	public Resource(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getDepartment() {
		return department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resource other = (Resource) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : "
				+ department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
	}
}
package com.java8.interview.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class EmployeeStreamDemo {
	static List<Employee> employeeList = new ArrayList<Employee>();

	public static void main(String[] args) {

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		employeeList.add(new Employee(277, "kamol Patidar", 39, "Female", "Product Development", 2017, 1235700.0));

		// Query 1 : How many male and female employees are there in the organization?
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
		// Query 6 : Count the number of employees in each department?
		System.out.println("\n");
		method6();
		System.out.println("\n");
		// Query 7 : What is the average salary of each department?
		method7();
		System.out.println("\n");
		// Query 8 : Get the details of youngest male employee in the product
		// development department?
		method8();
		System.out.println("\n");
		// Query 9 : Who has the most working experience in the organization?
		method9();
		System.out.println("\n");
		// Query 10 : How many male and female employees are there in the sales and
		// marketing team?
		method10();
		System.out.println("\n");
		// Query 11 : What is the average salary of male and female employees?
		method11();
		System.out.println("\n");
		// Query 12 : List down the names of all employees in each department?
		method12();
		System.out.println("\n");
		// Query 13 : What is the average salary and total salary of the whole
				// organization?
		method13();
	}

	public static void method1() {
		System.out.println("Query 1 : How many male and female employees are there in the organization?");
		Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(noOfMaleAndFemaleEmployees);
		
		System.out.println("Query 1 : How many male and female employees are there in the organization?");
		employeeList.stream().filter(e -> e.getAge()> 40).map(Employee::getDepartment)
		.collect(Collectors.toList()).forEach(System.out::println);
		
	}

	public static void method2() {
		System.out.println("Query 2 : Print the name of all departments in the organization?");
		List<String> depList = employeeList.stream().map(Employee::getDepartment).distinct()
				.collect(Collectors.toList());
		System.out.println(depList);
	}

	public static void method3() {
		System.out.println("Query 3 : Average age of of All employees?");
		Double avgAge = employeeList.stream().mapToDouble(Employee::getAge).average().getAsDouble();
		System.out.println("Average age of of All employees:" + avgAge);
		
		Double dolkl = employeeList.stream().mapToDouble(Employee::getSalary).max().getAsDouble();

		Map<String, Double> averageAgeOfMaleAndFemaleEmployee = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println("Average age of.." + averageAgeOfMaleAndFemaleEmployee);
	}

	public static void method4() {
		System.out.println("Query 4 : Get Details of highest paid employees?");

		// Option-1
		List<Employee> empListSorted = employeeList.stream().sorted((x, y) -> (int) (y.getSalary() - x.getSalary()))
				.collect(Collectors.toList());
		System.out.println("Highets Paid: " + empListSorted.get(0).getName());

		// Option-2
		Optional<Employee> highestPaidEmployeeWrapper = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println("Highets Paid: " + highestPaidEmployeeWrapper.get().getName());

		// Option-3
		Double maxSalary = employeeList.stream().mapToDouble(Employee::getSalary).max().getAsDouble();
		System.out.println("Highets Paid: " + maxSalary);
		
	}

	public static void method5() {
		System.out.println("Query 5 : Get the names of all employees who have joined after 2015??");
		List<String> empList = employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName)
				.collect(Collectors.toList());
		System.out.println("Employee Joined after 2015: " + empList);
	}

	public static void method6() {
		System.out.println("Query 6 : Count the number of employees in each department?");
		Map<String, Long> noEmpEachDept = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		for (Map.Entry<String, Long> m : noEmpEachDept.entrySet()) {
			System.out.println("Employees Dept:" + m.getKey() + " Count:" + m.getValue());
		}
		
		noEmpEachDept.forEach((k,v) -> System.out.println("Department: " + k + " Count: " + v));
	}

	public static void method7() {
		System.out.println("Query 7 : What is the average salary of each department?");
		Map<String, Double> avgSalaryEachDept = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		for (Map.Entry m : avgSalaryEachDept.entrySet()) {
			System.out.println("Employees Dept " + m.getKey() + " Avg Salary:" + m.getValue());
		}
	}

	public static void method8() {
		System.out.println(
				"Query 8 : Get the details of youngest male employee in the product " + "development department?");
		List<String> empList = employeeList.stream()
				.filter(e -> e.getDepartment().equals("Product Development") && e.getGender().equals("Male"))
				.sorted((e1, e2) -> (int) (e1.getAge() - e2.getAge())).map(Employee::getName)
				.collect(Collectors.toList());
		System.out.println(empList.get(0));

		// Option2
		Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper = employeeList.stream()
				.filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development")
				.min(Comparator.comparingInt(Employee::getAge));

		Employee youngestMaleEmployeeInProductDevelopment = youngestMaleEmployeeInProductDevelopmentWrapper.get();

		System.out.println("Details Of Youngest Male Employee In Product Development");
		System.out.println("----------------------------------------------");
		System.out.println("ID : " + youngestMaleEmployeeInProductDevelopment.getId());
		System.out.println("Name : " + youngestMaleEmployeeInProductDevelopment.getName() + " Age: "
				+ youngestMaleEmployeeInProductDevelopment.getAge());

		// Option3
		int minAge = employeeList.stream()
				.filter(e -> e.getDepartment().equals("Product Development") && e.getGender().equals("Male"))
				.mapToInt(Employee::getAge).min().getAsInt();
		System.out.println("----------------------------------------------");
		System.out.println("MinAge : " + minAge);

	}

	public static void method9() {
		System.out.println("Query 9 : Who has the most working experience in the organization?");
		Optional<Employee> seniorMostEmployeeWrapper = employeeList.stream()
				.sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();

		Employee seniorMostEmployee = seniorMostEmployeeWrapper.get();

		System.out.println("Senior Most Employee Details :");
		System.out.println("----------------------------");
		System.out.println("ID : " + seniorMostEmployee.getId());
		System.out.println("Name : " + seniorMostEmployee.getName());

		Employee seniorEmp = employeeList.stream().sorted((x, y) -> x.getYearOfJoining() - y.getYearOfJoining())
				.collect(Collectors.toList()).get(0);
		System.out.println("Senior Most EmployeeName : " + seniorEmp.getName());
	}

	public static void method10() {
		System.out.println("Query 10 : How many male and female employees are there in the sales and marketing?");

		Map<String, Long> m = employeeList.stream().filter(e -> e.getDepartment().equals("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		for (Map.Entry entry : m.entrySet()) {
			System.out.println("Employees Dept " + entry.getKey() + " Count:" + entry.getValue());
		}
		
		Map<String, Long> mfE = employeeList.stream()
				.filter(e -> e.getDepartment().equalsIgnoreCase("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
				
		mfE.forEach((k,v) -> System.out.println("Gender: " + k + " Count: " + v));
	}

	public static void method11() {
		System.out.println("Query 11 : What is the average salary of male and female employees?");
		Map<String, Double> m = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		for (Map.Entry entry : m.entrySet()) {
			System.out.println("Employees Gender " + entry.getKey() + " Salary:" + entry.getValue());
		}
		
		 employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,
				  Collectors.averagingDouble(Employee::getSalary)));
	}

	public static void method12() {
		System.out.println("Query 12 : List down the names of all employees in each department?");
		Map<String, List<Employee>> employeeListByDepartment = 
				employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		Set<Entry<String, List<Employee>>> entrySet = employeeListByDepartment.entrySet();
		
		System.out.println("List down the names of all employees in each department?");
		employeeListByDepartment.forEach((k,v) -> {
			System.out.println("Key.."+k+" value"+v);
		});

		for (Entry<String, List<Employee>> entry : entrySet) {
			System.out.println("--------------------------------------");

			System.out.println("Employees In " + entry.getKey() + " : ");
			System.out.println("--------------------------------------");
			List<Employee> list = entry.getValue();
			for (Employee e : list) {
				System.out.println(e.getName());
			}
		}
		
		employeeListByDepartment.entrySet().stream().sorted(Map.Entry.comparingByKey());
		
	}
	public static void method13() {
		employeeList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
		employeeList.stream().mapToDouble(Employee::getSalary).sum();
		
		Supplier<String> s  = () -> "Equal Na";
		System.out.println(s.get());
		
		Consumer<String> c = cn -> System.out.println(cn); 
		c.accept("Hello");
		
		java.util.function.Function<String, String > fc = name -> name.concat("Hello");
		System.out.println(fc.apply("Subhadip"));;
		
		employeeList.stream().sorted((e1,e2) -> e1.getDepartment().compareTo(e2.getDepartment()));
		employeeList.stream().sorted(Comparator.comparing(Employee::getDepartment));
	}

	
	
}

class Employee {
	int id;

	String name;

	int age;

	String gender;

	String department;

	int yearOfJoining;

	double salary;

	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
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
	public String toString() {
		return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : "
				+ department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
	}
}
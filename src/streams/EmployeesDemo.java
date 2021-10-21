package streams;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeesDemo {
    public static void main(String[] args)
    {
        List<Employee> employeesList=new ArrayList<>();
        employeesList.add(new Employee("John","FINANCE",1000));
        employeesList.add(new Employee("Tim","ADMIN",5000));
        employeesList.add(new Employee("Ryan","ADMIN",2000));
        employeesList.add(new Employee("Tom","FINANCE",20000));


        //Top paid salary employees
        Map<String,Employee> topPaidEmployees=employeesList.stream().
                collect(Collectors.groupingBy(e->e.getDepartment(),
                        Collectors.collectingAndThen(Collectors.minBy
                                (Comparator.comparingDouble(e->e.getSalary())), Optional::get)));

        //Get the all employees dept count
        Map<String ,Long> eachDeptCount=employeesList.stream().
                collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

        System.out.println("\nGroup By Dept**********\n");
        //Group by dept
        Map<String ,List<Employee>> groupByDept=employeesList.stream().
                collect(Collectors.groupingBy(e->e.getDepartment()));

        System.out.println(topPaidEmployees);
        System.out.println(eachDeptCount);
        System.out.println(groupByDept);
        
        System.out.println("\nGroup By Dept and count **********\n");
        
        Map<String,Long> mapDept = employeesList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        for(Map.Entry<String,Long> m : mapDept.entrySet()) {
			System.out.println("Value..."+ m.getValue() + "  Key.."+  m.getKey());
		}
        
        //Sort 
        System.out.println("\nSort By Keys **********\n");
        mapDept.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(emp -> System.out.println(emp));
        
        System.out.println("\nGroup By Emp and count **********\n");
        
        Map<Employee,Long> mapEmp = employeesList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(Map.Entry<Employee,Long> m : mapEmp.entrySet()) {
			System.out.println("Value..."+ m.getValue() + "  Key.."+  m.getKey());
		}
        //Sort
        System.out.println("\nSort By Salary*****\n");
        employeesList.stream().sorted((e1,e2) -> (int) (e2.getSalary() - e1.getSalary())).forEach(System.out::println);;

        //Sort
        System.out.println("\nSort By Dept*****\n");
        employeesList.stream().sorted((e1,e2) -> e1.getDepartment().compareTo(e2.getDepartment())).forEach(System.out::println);;
        
        
    }
}

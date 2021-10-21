package io.javabrains.unit3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {

	public static void main(String[] args) {
		 List<Product> productsList = new ArrayList<Product>();  
	        //Adding Products  
	        productsList.add(new Product(1,"HP Laptop",25000f));  
	        productsList.add(new Product(2,"Dell Laptop",30000f));  
	        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
	        productsList.add(new Product(4,"Sony Laptop",90100f));  
	        productsList.add(new Product(5,"Apple Laptop",90000f));  
	        productsList.stream()  
	                    .filter(p ->p.price> 30000)   // filtering price  
	                    .map(pm ->pm.price)          // fetching price  
	                    .forEach(pm -> System.out.println("Price.."+pm));  // iterating price  

	        System.out.println("\n \n");
	        
	        productsList.stream()  
            .filter(p -> p.name != "Dell Laptop")   // filtering name  
            .map(pm -> pm.name)          // fetching name  
            .forEach(System.out::println);
	        
	        System.out.println("\n Before Filter\n");
	        
	        productsList.forEach(System.out::println);
	        
	        System.out.println("\nAfter Filter\n");
	        
	        productsList.stream()
	        .filter(p -> p.name != "Dell Laptop").collect(Collectors.toList()).forEach(System.out::println);
	        
	}

}

class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}  
    
    
}  

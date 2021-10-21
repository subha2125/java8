package io.unit1;

public class Greeter {

	public void greet(Greeting greeting) {
		greeting.perform();
	}
	
	
	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		
		
		Greeting lambdaGreeting = () -> System.out.println("Hello Lamda2 world!");
		
		Greeting innerClassGreeting = new Greeting() {
			public void perform() {
				System.out.println("Hello InnerClass world!");
			}
		};
		
		greeter.greet(() -> System.out.println("Hello Lamda world!"));
		greeter.greet(innerClassGreeting);
		greeter.greet(lambdaGreeting);
		
		
		
		
		
	}

}




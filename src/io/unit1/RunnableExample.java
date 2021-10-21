package io.unit1;

public class RunnableExample {

	public static void main(String[] args) {
		Thread myThread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Printed inside Runnable");
				
			}
			
		});
		
		Thread myThreadJava8 = new Thread(() -> System.out.println("Printed inside Java8 Runnable"));
		
		myThread.run();
		myThreadJava8.run();
		
		Thread myLambdaThread = new Thread(() -> {
		
		 System.out.println("Printed inside Lambda Runnable");
		 System.out.println("Printed Again inside Lambda Runnable");
		
		});
		myLambdaThread.run();
		

	}

}

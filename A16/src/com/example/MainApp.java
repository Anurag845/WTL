package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] main) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Employee emp1 = context.getBean("employee",Employee.class);
		
		Employee emp2 = context.getBean("employee",Employee.class);
		
		if(emp1 == emp2) {
			System.out.println("Scope is singleton");
			System.out.println("Emp1 is " + emp1);
			System.out.println("Emp2 is " + emp2);
		}
		else {
			System.out.println("Scope is prototype");
			System.out.println("Emp1 is " + emp1);
			System.out.println("Emp2 is " + emp2);
		}
	}

}

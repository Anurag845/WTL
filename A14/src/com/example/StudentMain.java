package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student student = context.getBean("student",Student.class);
		
		Student student2 = context.getBean("student",Student.class);
		
		if(student == student2) {
			System.out.println("Scope is singleton");
		}
		else {
			System.out.println("Scope is not singleton");
		}
	}

}

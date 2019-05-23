package com.javawebservice.spring.springbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBasicsApplication {

	public static void main(String[] args) {
	
		ApplicationContext applicationContext = SpringApplication.run(SpringBasicsApplication.class, args);
		BinarySearchImpl binarySearchObj = applicationContext.getBean(BinarySearchImpl.class);
		int result= binarySearchObj.binarySearch(new int[] {12, 3,6, 4}, 1);
		System.out.println(result);
	}

}

package com.javawebservice.spring.springbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBasicsApplication {

	public static void main(String[] args) {
		
		BinarySearchImpl bsObj = new BinarySearchImpl(new BubbleSortAlgorithm());
		int result= bsObj.binarySearch(new int[] {12, 3,6, 4}, 1);
		System.out.println(result);
		SpringApplication.run(SpringBasicsApplication.class, args);
	}

}

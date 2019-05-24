package com.spring.boot.springBootin10steps;

import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootIn10StepsApplication {

	public static void main(String[] args) {
		ApplicationContext contextApp =  SpringApplication.run(SpringBootIn10StepsApplication.class, args);
		for(String name: contextApp.getBeanDefinitionNames()) {
			System.out.println("Beans name:" + name);
		}
	}

}

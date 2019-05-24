package com.java.restful.RESTfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HellowordController {
	
	// GET
	// URI helloworld
	//@GetMapping("/hello-world")
	@RequestMapping(method = RequestMethod.GET, path="/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}
	
	// Get bean 
	@RequestMapping(method = RequestMethod.GET, path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello ----- World");
	}
	
	// With path parameter
	@RequestMapping(method = RequestMethod.GET, path="/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBeanParam(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
 }

package com.java.restful.RESTfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HellowordController {
	
	// GET
	// URI helloworld
	//@GetMapping("/hello-world")
	@RequestMapping(method = RequestMethod.GET, path="/helloworld")
	public String helloWorld() {
		return "Hello World!";
	}
 }

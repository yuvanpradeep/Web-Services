package com.java.restful.RESTfulwebservices.Filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean retreiveSomeBean() {
		return new SomeBean("Value1", "Value2", "Value3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retreiveListSomeBean() {
		return Arrays.asList(new SomeBean("Value1", "Value2", "Value3"), new SomeBean("Value11", "Value22", "Value33"));
	}
}

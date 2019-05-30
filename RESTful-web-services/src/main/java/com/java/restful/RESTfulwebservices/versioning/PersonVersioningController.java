package com.java.restful.RESTfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
@GetMapping("v1/person")
public PersonV1 personV1() {
	return new PersonV1("Yuvan Pradeep");
}

@GetMapping("v2/person")
public PersonV2 personV2() {
	return new PersonV2(new Name("Yuvan","Pradeep"));
}
}

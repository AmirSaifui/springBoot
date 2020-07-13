package com.firstWebService.rest.services.restfulwebservices.test;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:6969")
public class RestControllerTesting {
	
	@GetMapping(path="/hello-world-bean/path-variable/{name}")
	public HellowWorldBean helloWorld(@PathVariable String name) {
		return new HellowWorldBean(String.format("Hello World, %s",name));
//		throw new RuntimeException("Something is wrong");
	}

}

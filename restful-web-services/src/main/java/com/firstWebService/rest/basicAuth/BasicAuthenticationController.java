package com.firstWebService.rest.basicAuth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:6969")
public class BasicAuthenticationController {
	
	@GetMapping(path="/basicAuth")
	public AuthenticationBean helloWorldBean() {
		return new AuthenticationBean("You are authenticated");
//		throw new RuntimeException("Something is wrong");
	}

}

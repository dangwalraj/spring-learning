package com.learning.spring.mvc;


import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@GetMapping(value = "hello", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getHello() {
		return "Hello from controller";
		
	}
	
	@GetMapping(value = "", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getRoot() {
		return "Accessed the root URL !";
		
	}
	
	


}

package com.learning.spring.springlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.learning.spring")
public class SpringLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearningApplication.class, args);
	}

}

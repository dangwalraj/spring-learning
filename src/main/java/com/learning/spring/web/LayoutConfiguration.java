package com.learning.spring.web;

import org.springframework.context.annotation.Configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;

/**
 * Hook to enable Thymeleaf integration with 
 * Spring. 
 * 
 *
 */
@Configuration
public class LayoutConfiguration {

	
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}
}

package com.learning.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class BasicSecurityManager extends WebSecurityConfigurerAdapter {
	
	private AuthenticationManager authManager;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		authorizeRequests().antMatchers("/").permitAll()
		.anyRequest().authenticated()
		.and()
		.httpBasic().and()
		.logout()
		.permitAll();
	}
	
	@Bean
	public UserDetailsService userDetailService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();
		
		
		return new InMemoryUserDetailsManager(user);
	}

}

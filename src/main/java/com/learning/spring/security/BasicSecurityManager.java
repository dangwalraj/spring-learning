package com.learning.spring.security;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

@EnableWebSecurity
@Configuration
public class BasicSecurityManager extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		authorizeRequests().antMatchers("/","/css/**", "/js/**", "/images/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login")
		.defaultSuccessUrl("/home")
	//	.failureHandler(getCustomHander())
		
		.failureUrl("/login?error")
		.permitAll()
		.and()
		.logout().invalidateHttpSession(true)
		.deleteCookies("JSESSIONID");
		/*.permitAll();
		.httpBasic().and()
		.logout()
		.permitAll();*/
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@Bean
	public AuthenticationFailureHandler getCustomHander() {
		return (request, response, exception) ->
		{
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.sendRedirect("/login?error="+ exception.getMessage());
//			Map<String, Object> data = new HashMap<String, Object>();
//			data.put("timestamp", Calendar.getInstance().getTime());
//			data.put("exception",  exception.getMessage());
//			
//			String objMapperOut = new ObjectMapper().writeValueAsString(data);
//			System.out.println("Error from Login Page"+ objMapperOut);
//			response.getOutputStream().println(new ObjectMapper().writeValueAsString(data)
//					);
		};
		
	}
	
	@Bean
	public AuthenticationFailureHandler getCustomURLHander() {
		return (request, response, exception) ->
		{
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("timestamp", Calendar.getInstance().getTime());
			data.put("exception",  exception.getMessage());
			
			String objMapperOut = new ObjectMapper().writeValueAsString(data);
			System.out.println("Error from Login Page"+ objMapperOut);
			response.getOutputStream().println(new ObjectMapper().writeValueAsString(data)
					);
		};
		
	}


}

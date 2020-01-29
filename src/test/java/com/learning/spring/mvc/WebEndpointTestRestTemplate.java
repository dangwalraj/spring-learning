package com.learning.spring.mvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.learning.spring.springlearning.SpringLearningApplication;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
classes = SpringLearningApplication.class)
@AutoConfigureMockMvc
public class WebEndpointTestRestTemplate {

	@LocalServerPort
	private int port;

	@Autowired
	private MockMvc mockMvc;

	
	@org.junit.Test
	public void testLoginProcess() throws Exception{
		UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken("user",  "password");
		mockMvc.perform(post("/login").param("username", "user").param("password", "password").with(csrf()))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/home"));

		
	}
}

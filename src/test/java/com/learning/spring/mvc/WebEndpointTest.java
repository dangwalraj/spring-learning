package com.learning.spring.mvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.learning.spring.springlearning.SpringLearningApplication;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = SpringLearningApplication.class)
public class WebEndpointTest {

	@Autowired
	private MockMvc mockMvc;
	
	@org.junit.Test
	public void contextLoads() {
	}
	
	@org.junit.Test
	public void testNonAuthenticatedEP() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string("Accessed the root URL !"));
	}

	@org.junit.Test
	public void testLoginPageRedirection() throws Exception{
		mockMvc.perform(get("/Login.html")).andDo(print()).andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("http://localhost/login"));
				
		
	}
	
	@org.junit.Test
	public void testLogin() throws Exception{
		mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk());
				
		
	}
}

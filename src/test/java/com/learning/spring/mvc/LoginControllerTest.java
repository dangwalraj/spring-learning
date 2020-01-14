package com.learning.spring.mvc;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.learning.spring.springlearning.SpringLearningApplication;

@RunWith(SpringRunner.class)
@WebMvcTest
@SpringBootTest(classes = SpringLearningApplication.class)

public class LoginControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
	//	this.mockMvc = MockMvcBuilders.standaloneSetup(new LoginController()).build();
	//	MockMvcBuilders.webAppContextSetup()
	}
	
	@Test
	public void test() throws Exception
	{
		//this.mockMvc.perform(get("/test/hello")).andExpect(status().isOk());
		System.out.println(this.mockMvc);
	}

}

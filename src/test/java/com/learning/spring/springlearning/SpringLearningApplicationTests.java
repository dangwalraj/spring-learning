package com.learning.spring.springlearning;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebMvcTest
class SpringLearningApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	  //private WebApplicationContext webApplicationContext;
	  private MockMvc mockMvc;

	 @Before
	  public void setUp() {
	   // mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	 }
	
	
	
	@Test
	public void test() throws Exception
	{
		System.out.println(this.mockMvc);
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
		
	}

}

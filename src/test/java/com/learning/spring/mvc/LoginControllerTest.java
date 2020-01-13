package com.learning.spring.mvc;


import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LoginControllerTest {
	private MockMvc mockMvc;
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new LoginController()).build();
	}
	@Test
	public void test() throws Exception
	{
		this.mockMvc.perform(get("/test/hello")).andExpect(status().isOk());
	}

}

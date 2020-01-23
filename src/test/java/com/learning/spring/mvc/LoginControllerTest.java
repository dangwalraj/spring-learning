package com.learning.spring.mvc;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.learning.spring.repository.UserInfoRepository;
import com.learning.spring.repository.UserInfoService;
import com.learning.spring.security.BasicSecurityManager;
import com.learning.spring.springlearning.SpringLearningApplication;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = {WebLoginController.class, BasicSecurityManager.class, LoginController.class})
public class LoginControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private UserInfoRepository userRepo;
	
	@MockBean
	private UserInfoService loginMockService;
	
	@Before
	public void setup() {
	//	this.mockMvc = MockMvcBuilders.standaloneSetup(new LoginController()).build();
	//	MockMvcBuilders.webAppContextSetup()
	}
	
	@Test
	public void testOne() throws Exception
	{
		//this.mockMvc.perform(get("/test/hello")).andExpect(status().isOk());
		System.out.println(this.mockMvc);
	}

}

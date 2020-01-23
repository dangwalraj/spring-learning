package com.learning.spring.mvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.learning.spring.repository.UserInfoRepository;
import com.learning.spring.repository.UserInfoService;
import com.learning.spring.springlearning.SpringLearningApplication;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = {SpringLearningApplication.class})
//@ExtendWith(SpringExtension.class)
public class WebEndpointTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private UserInfoRepository userRepo;
	
	@MockBean
	private UserInfoService loginMockService;
	
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
	
	@org.junit.Test
	public void testLoginProcess() throws Exception{
		UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken("user",  "password");
		mockMvc.perform(post("/login").param("username", "user").param("password", "password").with(csrf()))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/home"));

		
	}
	

	
}

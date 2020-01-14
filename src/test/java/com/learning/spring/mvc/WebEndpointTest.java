package com.learning.spring.mvc;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
class WebEndpointTest {

	@Autowired
	  private MockMvc mockMvc;
	@Test
	void test() {
		fail("Not yet implemented");
	}

}

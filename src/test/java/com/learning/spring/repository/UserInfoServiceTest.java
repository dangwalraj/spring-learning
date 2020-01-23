package com.learning.spring.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.spring.entity.UserInfo;
import com.learning.spring.springlearning.SpringLearningApplication;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {SpringLearningApplication.class})
//@Sql({"/datasource/schema.sql", "/datasource/data.sql"})
public class UserInfoServiceTest {

	@Autowired
	private UserInfoService userInfoService;
	
	@Test
	public void getUserInfoFromService() {
		UserInfo ui = userInfoService.findByUserId("user");
		assertEquals(ui.getName(), "user");
	}
}

package com.learning.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebLoginController {

	@GetMapping("/login")
	public String getLoginPage(Model model)
	{
		//model.addAttribute("user", new UserInfo());
		return "login";
	}
	
	@GetMapping("/home")
	public String getHomePage()
	{
		return "home";
	}
}

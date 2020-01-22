package com.learning.spring.mvc;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebLoginController {


	/**
	 * @TODO: Identify a better way to handle Login Process. Spring OOTB limits the error handling
	 *        mechanism during Login Process.
	 * @param error
	 * @param model
	 * @return
	 */
	@GetMapping(path = "/login" )
	public String getLoginPage(@RequestParam(value = "error") Optional<String> error, Model model)
	{
		return "Login";
	}
	@GetMapping("/home")
	public String getHomePage()
	{
		return "home";
	}
}

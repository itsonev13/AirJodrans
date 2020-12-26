package com.jordans.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jordans.models.TestUser;
import com.jordans.services.RegisterService;

@Controller
@RequestMapping("/")
public class RegisterController extends BaseController {

	private RegisterService registerService;

	@Autowired
	public RegisterController(RegisterService registerService) {
		this.registerService = registerService;
	}

	@GetMapping("register")
	public ModelAndView register() {

		ModelAndView modelAndView = super.view("register", "pageName", "Sign up");

		return modelAndView;
	}

	@PostMapping(path = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView registration(TestUser u) {
		int b = 5;
		ModelAndView modelAndView = super.view("register", "pageName", "Sign up");
		return modelAndView;
	}

}

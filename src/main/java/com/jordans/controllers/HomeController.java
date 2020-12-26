package com.jordans.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController {
	@GetMapping("home")
	public ModelAndView home() {
		return super.view("index", "pageName", "Home");
	}

	@GetMapping("")
	public ModelAndView index() {
		return super.view("index", "pageName", "Home");
	}
}
package com.jordans.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AboutController extends BaseController {

	@GetMapping("about")
	public ModelAndView index() {
		return super.view("about", "pageName", "About");
	}
}
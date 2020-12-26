package com.jordans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jordans.models.Shoe;
import com.jordans.services.ShoeService;

@Controller
public class UserController extends BaseController {
	private ShoeService shoeService;

	@Autowired
	public UserController(ShoeService shoeService) {
		this.shoeService = shoeService;
	}

	@GetMapping("/user")
	public ModelAndView index() {
		return super.view("index", "pageName", "Home");
	}

	@GetMapping("/favourite")
	public ModelAndView myFavourite() {
		List<Shoe> shoes = shoeService.getTwoShoes(PageRequest.of(0, 2, Sort.by("id")));
		ModelAndView modelAndView = super.view("userfavourite", "pageName", "My Favourite");
		modelAndView.addObject("shoes", shoes);
		return modelAndView;
	}

	@GetMapping("/addfavourite")
	public ModelAndView addFavourite() {
		List<Shoe> shoes = shoeService.getShoes();
		ModelAndView modelAndView = super.view("user", "pageName", "Profile");
		modelAndView.addObject("shoes", shoes);
		return modelAndView;
	}
}

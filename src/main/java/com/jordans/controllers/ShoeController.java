package com.jordans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jordans.models.Shoe;
import com.jordans.services.ShoeService;

@Controller
@RequestMapping("/")
public class ShoeController extends BaseController {
	private ShoeService shoeService;

	@Autowired
	public ShoeController(ShoeService shoeService) {
		this.shoeService = shoeService;
	}

	@GetMapping("shoes")
	public ModelAndView index() {
		List<Shoe> shoes = shoeService.getTwoShoes(PageRequest.of(0, 2, Sort.by("id")));
		ModelAndView modelAndView = super.view("shoes", "pageName", "Shoes");
		modelAndView.addObject("shoes", shoes);
		modelAndView.addObject("isLastPage", false);
		return modelAndView;
	}

	@GetMapping("shoesP{page}")
	public ModelAndView shoePage(@PathVariable int page) {
		boolean isLastPage = false;
		int numberOfShoePages = this.shoeService.getNumberOfShoePages();
		if (numberOfShoePages < page) {
			return super.view("errorpage");
		}
		List<Shoe> shoes = null;
		if (page == 1) {
			shoes = shoeService.getTwoShoes(PageRequest.of(0, 2, Sort.by("id")));
		}
		if (page > 1) {
			shoes = shoeService.getTwoShoes(PageRequest.of((page - 1), 2, Sort.by("id")));
		}
		ModelAndView modelAndView = super.view("shoes", "pageName", "Shoes");
		modelAndView.addObject("shoes", shoes);
		if (numberOfShoePages == page) {
			isLastPage = true;
		}
		modelAndView.addObject("isLastPage", isLastPage);
		return modelAndView;
	}
}

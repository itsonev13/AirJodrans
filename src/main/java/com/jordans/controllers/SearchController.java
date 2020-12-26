package com.jordans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jordans.models.Shoe;
import com.jordans.services.ShoeService;

@Controller
@RequestMapping("/")
public class SearchController extends BaseController {
	private ShoeService shoeService;

	@Autowired
	public SearchController(ShoeService shoeService) {
		this.shoeService = shoeService;
	}

	@PostMapping("search")
	public ModelAndView home(@RequestParam("searchString") String search) {

		List<Shoe> searchedShoes = shoeService.getShoeBySearchString(search);
		ModelAndView modelAndView = super.view("searchedshoe", "pageName", "Shoes");
		modelAndView.addObject("shoes", searchedShoes);
		return modelAndView;
	}

}

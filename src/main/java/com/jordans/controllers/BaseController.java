package com.jordans.controllers;

import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {

	public ModelAndView view(String viewName) {
		return new ModelAndView(viewName);
	}

	public ModelAndView view(String viewName, String objectName, Object object) {
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject(objectName, object);

		return modelAndView;
	}

	public ModelAndView redirect(String url) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("redirect:" + url);

		return modelAndView;
	}
}

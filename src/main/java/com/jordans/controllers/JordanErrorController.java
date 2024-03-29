//package com.jordans.controllers;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class JordanErrorController implements ErrorController {
//
//	@RequestMapping("/error")
//	public String handleError(HttpServletRequest request) {
//		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//
//		if (status != null) {
//			Integer statusCode = Integer.valueOf(status.toString());
//
//			if (statusCode == HttpStatus.NOT_FOUND.value()) {
//				return "errorpage";
//			}
//		}
//		return "about";
//	}
//
//	@Override
//	public String getErrorPath() {
//		return null;
//	}
//}
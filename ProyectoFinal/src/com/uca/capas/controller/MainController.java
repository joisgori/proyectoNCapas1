package com.uca.capas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/")
	public String initMain() {
		return "main";
	}
	
	@RequestMapping("/verifyLogin")
	public ModelAndView verifyUser() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	
}

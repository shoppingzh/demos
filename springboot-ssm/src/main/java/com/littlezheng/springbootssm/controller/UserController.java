package com.littlezheng.springbootssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "user")
public class UserController {

	@GetMapping(path = "/")
	public ModelAndView index(){
		return new ModelAndView("user/index");
	}
	
}

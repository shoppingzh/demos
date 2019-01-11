package com.littlezheng.springbootthymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.littlezheng.springbootthymeleaf.entity.User;

@Controller
@RequestMapping(path = "user")
public class UserController {
	
	private static List<User> USERS = new ArrayList<>();
	static{
		USERS.add(new User("王二蛋", 23));
		USERS.add(new User("老李头", 45));
	}

	@GetMapping(path = "")
	public String index(Model model){
		model.addAttribute("users", USERS);
		return "users";
	}
	
}

package com.littlezheng.springbootssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.littlezheng.springbootssm.entity.User;
import com.littlezheng.springbootssm.service.UserService;

@Controller
@RequestMapping(path = "user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@GetMapping(path = "index")
	public String index(){
		return "user/index";
	}

	@GetMapping(path = "")
	public @ResponseBody List<User> listAll(){
		return userService.list();
	}
	
	@PostMapping(path = "add")
	public @ResponseBody String newUser(@ModelAttribute User user) {
		return userService.save(user);
	}
	
}

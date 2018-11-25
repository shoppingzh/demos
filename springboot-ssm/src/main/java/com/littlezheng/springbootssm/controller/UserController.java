package com.littlezheng.springbootssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.littlezheng.springbootssm.dao.UserMapper;
import com.littlezheng.springbootssm.entity.User;

@Controller
@RequestMapping(path = "user")
public class UserController {
	
	@Resource
	private UserMapper userMapper;
	
	@GetMapping(path = "index")
	public String index(){
		return "user/index";
	}

	@GetMapping(path = "")
	public @ResponseBody List<User> listAll(){
		return userMapper.selectAll();
	}
	
}

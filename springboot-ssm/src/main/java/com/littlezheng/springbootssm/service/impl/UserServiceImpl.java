package com.littlezheng.springbootssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.littlezheng.springbootssm.dao.UserMapper;
import com.littlezheng.springbootssm.entity.User;
import com.littlezheng.springbootssm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	@Transactional
	public String save(User user) {
		userMapper.insert(user);
		return String.valueOf(user.getId());
	}

	@Override
	public List<User> list() {
		return userMapper.selectAll();
	}

}

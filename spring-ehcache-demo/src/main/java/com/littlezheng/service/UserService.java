package com.littlezheng.service;

import org.springframework.cache.annotation.Cacheable;

import com.littlezheng.dao.UserDao;
import com.littlezheng.domain.User;
import com.littlezheng.domain.UserBo;

public class UserService {

	private UserDao userDao;
	
	@Cacheable(value="userCache", key="#name")
	public UserBo getUserByName(String name){
		User user = userDao.getByName(name);
		UserBo userBo = new UserBo();
		userBo.setName(user.getName());
		userBo.setAge(user.getAge());
		return userBo;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}

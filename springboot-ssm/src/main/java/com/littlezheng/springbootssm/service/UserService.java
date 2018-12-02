package com.littlezheng.springbootssm.service;

import java.util.List;

import com.littlezheng.springbootssm.entity.User;

public interface UserService {

	/**
	 * 保存用户
	 * 
	 * @param user
	 * @return
	 */
	String save(User user);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	List<User> list();

}

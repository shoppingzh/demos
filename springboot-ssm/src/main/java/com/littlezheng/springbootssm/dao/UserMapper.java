package com.littlezheng.springbootssm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.littlezheng.springbootssm.entity.User;

@Repository
public interface UserMapper {

	void insert(User user);
	
	void update(User user);
	
	void deleteById(Long id);
	
	List<User> selectAll();
	
	List<User> select(User user);
	
}

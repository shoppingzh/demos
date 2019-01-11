package com.littlezheng.springbootssm;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.littlezheng.springbootssm.dao.UserMapper;
import com.littlezheng.springbootssm.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Resource
	private UserMapper userMapper;
	
	@Test
	public void insert(){
		User user = new User();
		user.setId(1L);
		user.setAccount("xpzheng");
		user.setPassword("123");
		user.setName("郑晓平");
		user.setAge(23);
		userMapper.insert(user);
	}
	
	@Test
	public void selectAll(){
		System.out.println(userMapper.selectAll());
	}
	
	@Test
	public void select(){
		User user = new User();
		user.setName("郑晓平");
		System.out.println(userMapper.select(user));
		user.setAccount("zxp");
		System.out.println(userMapper.select(user));
	}
	
}

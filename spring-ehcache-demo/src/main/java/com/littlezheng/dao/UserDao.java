package com.littlezheng.dao;

import java.util.ArrayList;
import java.util.List;

import com.littlezheng.domain.User;

public class UserDao {
	
	static List<User> users = new ArrayList<User>();
	static{
		users.add(new User("zxp", 23));
		users.add(new User("lw", 56));
		users.add(new User("zs", 24));
		users.add(new User("ls", 45));
	}

	public User getByName(String name){
		for(User user : users){
			if(user.getName().equals(name)){
				return user;
			}
		}
		
		return null;
	}
	
}

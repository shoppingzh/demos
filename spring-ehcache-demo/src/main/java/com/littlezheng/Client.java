package com.littlezheng;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.littlezheng.service.UserService;

public class Client {
	
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		UserService userService = ctx.getBean(UserService.class);
		System.out.println("第一次获取：" + userService.getUserByName("zxp"));
		
		System.out.println("第二次获取：" + userService.getUserByName("zxp"));
		Thread.sleep(10000);
		System.out.println("第三次获取(10s后)：" + userService.getUserByName("zxp"));
	}

}

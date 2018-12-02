package com.littlezheng.springbootssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.littlezheng.springbootssm.dao")
public class SpringbootSsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSsmApplication.class, args);
	}
	
}

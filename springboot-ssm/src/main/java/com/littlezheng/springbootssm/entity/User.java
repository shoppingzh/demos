package com.littlezheng.springbootssm.entity;

import lombok.Data;

public @Data class User {

	private Long id;
	private String account;
	private String password;
	private String name;
	private Integer age;
	
}

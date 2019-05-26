package com.littlezheng.ssedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SseDemoApplication.class, args);
	}

}

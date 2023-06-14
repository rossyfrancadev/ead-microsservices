package com.ead.authuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.ead.authuser.controllers")
public class AuthuserApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthuserApplication.class, args);
	}

}

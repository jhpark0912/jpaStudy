package com.jpabook.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		hello hello = new hello();
		hello.setData("data");
		String data = hello.getData();
		System.out.println("data = " + data);
		SpringApplication.run(JpaApplication.class, args);
	}

}

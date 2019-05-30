package com.mjly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mjly.dao")
public class MjlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MjlyApplication.class, args);
	}

}

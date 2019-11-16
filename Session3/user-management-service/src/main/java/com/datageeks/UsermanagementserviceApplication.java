package com.datageeks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.datageeks")

public class UsermanagementserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermanagementserviceApplication.class, args);
	}

}

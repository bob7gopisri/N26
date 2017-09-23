package com.transactions.hometest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.transactions.hometest"})
public class HometestApplication {
	public static void main(String[] args) {
		SpringApplication.run(HometestApplication.class, args);
	}
}

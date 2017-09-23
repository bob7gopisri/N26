package com.transactions.hometest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan({"controller", "service"})
@SpringBootApplication(scanBasePackages={"com.transactions.hometest"})
public class HometestApplication {
	public static void main(String[] args) {
		SpringApplication.run(HometestApplication.class, args);
	}
}

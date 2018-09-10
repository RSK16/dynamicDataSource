package com.example.apodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ApodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApodbApplication.class, args);
	}
}

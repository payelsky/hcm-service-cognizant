package com.springboot.hcmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HcmServiceCognizantApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcmServiceCognizantApplication.class, args);
	}

}

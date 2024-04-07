package com.paultamayo.demo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RestfulApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulApiDemoApplication.class, args);
	}

}

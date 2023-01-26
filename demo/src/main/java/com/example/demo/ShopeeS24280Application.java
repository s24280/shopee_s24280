package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopeeS24280Application {

	public static void main(String[] args) {
		SpringApplication.run(ShopeeS24280Application.class, args);
	}

	public ShopeeS24280Application(ShopService shopService) {
		//System.out.println(shopService.findItemByName("milk"));
	}
}

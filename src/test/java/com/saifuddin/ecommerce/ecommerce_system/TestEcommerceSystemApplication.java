package com.saifuddin.ecommerce.ecommerce_system;

import org.springframework.boot.SpringApplication;

public class TestEcommerceSystemApplication {

	public static void main(String[] args) {
		SpringApplication.from(EcommerceSystemApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

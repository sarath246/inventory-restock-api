package com.inventory.restock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.inventory.*")
public class InventoryRestockApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryRestockApplication.class, args);
	}

}

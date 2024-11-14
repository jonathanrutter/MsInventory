package com.wuppski.microservices.ms_inventory;

import org.springframework.boot.SpringApplication;

public class TestMsInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.from(MsInventoryApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

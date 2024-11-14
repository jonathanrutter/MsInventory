package com.wuppski.microservices.ms_inventory;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MsInventoryApplicationTests {

	@ServiceConnection
	static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mySQLContainer.start();
	}

	@Test
	void requestAmountInStockTest() {
		//Request amount in stock
		boolean responseValue = RestAssured.given()
				.contentType("application/json")
				.when()
				.param("skuCode", "Bosch_Extractor2")
				.param("quantity", "60")
				.get("/api/inventory")
				.then()
				.log().all()
				.statusCode(200)
				.extract()
				.response().as(Boolean.class);

		Assertions.assertTrue(responseValue);
	}

	@Test
	void requestAmountOutOfStockTest() {
		//Request amount in stock
		boolean responseValue = RestAssured.given()
				.contentType("application/json")
				.when()
				.param("skuCode", "Bosch_Extractor2")
				.param("quantity", "300")
				.get("/api/inventory")
				.then()
				.log().all()
				.statusCode(200)
				.extract().response().as(Boolean.class);

		Assertions.assertFalse(responseValue);
	}

}
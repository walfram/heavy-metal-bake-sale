package stock.v2021.controllers;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import stock.v2021.domain.Product;
import stock.v2021.domain.ProductImpl;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StockControllerTest {

	@LocalServerPort
	private int port;

	@BeforeEach
	public void beforeEach() {
		RestAssured.port = port;
	}

	@Test
	public void test_stock_products() {
		Product[] products = given().log().all().when().get("/api/v2021/stock").then().statusCode(HttpStatus.OK.value())
				.extract().as(ProductImpl[].class);

		assertNotNull(products);
		assertEquals(4, products.length);
	}

}

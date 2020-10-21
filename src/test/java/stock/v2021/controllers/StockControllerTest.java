package stock.v2021.controllers;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import stock.v2021.domain.dto.RsProduct;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StockControllerTest extends AbstractTestNGSpringContextTests {

	@LocalServerPort
	private int port;

	@BeforeClass
	public void init() {
		RestAssured.port = port;
		RestAssured.defaultParser = Parser.JSON;
	}

	@Test
	public void test_scenario_1() {
		// RsProduct[] products = get("/v2021/stock").as(RsProduct[].class);
		RsProduct[] rs = given().log().all().when().get("/api/v2021/stock").then().statusCode(HttpStatus.OK.value()).extract()
				.as(RsProduct[].class);

		List<RsProduct> products = Arrays.asList(rs);

		assertFalse(products.isEmpty());
		assertEquals(products.size(), 4);
	}

}

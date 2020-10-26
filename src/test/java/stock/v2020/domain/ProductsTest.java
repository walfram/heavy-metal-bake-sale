package stock.v2020.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;

import stock.v2020.domain.exception.NotEnoughMoneyException;
import stock.v2020.domain.exception.NotEnoughStockException;
import stock.v2020.domain.exception.ProductNotFoundException;

@ExtendWith(SpringExtension.class)
public class ProductsTest {

	private final ObjectMapper mapper = new ObjectMapper();

	private JsonNode productsJson;

	private Products products;

	@BeforeEach
	public void beforeEach() throws IOException {
		productsJson = mapper.readTree(Resources.getResource("stock.products.json"));
		products = new ConstProducts(new JsonProducts(productsJson));
	}

	@Test
	public void test_purchase_reduces_stock_quantity() throws NotEnoughStockException, NotEnoughMoneyException,
			ProductNotFoundException {

		int before = products.quantityOf("W");

		products.purchase(new Order(10.0, new Item("W", 5)));

		int after = products.quantityOf("W");

		assertTrue(before > after);
		assertEquals(after + 5, before);
	}

	@Test
	public void test_purchase_change() throws NotEnoughStockException, NotEnoughMoneyException, ProductNotFoundException {
		double change = products.purchase(
				new Order(5.0, new Item("B", 1), new Item("M", 1), new Item("C", 1), new Item("W", 1)));

		assertEquals(0.5, change);
	}

	@Test
	public void test_purchase_not_enough_paid() {
		assertThrows(NotEnoughMoneyException.class, () -> {
			products.purchase(new Order(10.0, new Item("W", 10)));
		});
	}

	@Test
	public void test_purchase_invalid_product() {
		assertThrows(ProductNotFoundException.class, () -> {
			products.purchase(new Order(10.0, new Item("XXX", 1)));
		});
	}

	@Test
	public void test_purchase_invalid_product_quantity() throws IOException {
		assertThrows(NotEnoughStockException.class, () -> {
			products.purchase(new Order(10.0, new Item("B", 100)));
		});
	}

}

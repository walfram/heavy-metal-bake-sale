package stock.v2021.domain;

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

import stock.v2021.domain.exception.NotEnoughMoneyException;
import stock.v2021.domain.exception.NotEnoughStockException;
import stock.v2021.domain.exception.ProductNotFoundException;

@ExtendWith(SpringExtension.class)
public class StockTest {

	private final ObjectMapper mapper = new ObjectMapper();

	private JsonNode productsJson;

	private Stock stock;

	@BeforeEach
	public void beforeEach() throws IOException {
		productsJson = mapper.readTree(Resources.getResource("stock.products.json"));
		Products products = new ProductsImpl(productsJson);
		stock = new StockImpl(products);
	}

	@Test
	public void test_purchase_reduces_stock_quantity() throws NotEnoughStockException, NotEnoughMoneyException,
			ProductNotFoundException {

		int before = stock.quantityOf("W");

		stock.purchase(new Purchase(10.0, new ProductRequest("W", 5)));

		int after = stock.quantityOf("W");

		assertTrue(before > after);
		assertEquals(after + 5, before);
	}

	@Test
	public void test_purchase_change() throws NotEnoughStockException, NotEnoughMoneyException, ProductNotFoundException {
		double change = stock.purchase(
				new Purchase(5.0, new ProductRequest("B", 1), new ProductRequest("M", 1), new ProductRequest("C", 1),
						new ProductRequest("W", 1)));

		assertEquals(0.5, change);
	}

	@Test
	public void test_purchase_not_enough_paid() {
		assertThrows(NotEnoughMoneyException.class, () -> {
			stock.purchase(new Purchase(10.0, new ProductRequest("W", 10)));
		});
	}

	@Test
	public void test_purchase_invalid_product() {
		assertThrows(ProductNotFoundException.class, () -> {
			stock.purchase(new Purchase(10.0, new ProductRequest("XXX", 1)));
		});
	}

	@Test
	public void test_purchase_invalid_product_quantity() throws IOException {
		assertThrows(NotEnoughStockException.class, () -> {
			stock.purchase(new Purchase(10.0, new ProductRequest("B", 100)));
		});
	}

}

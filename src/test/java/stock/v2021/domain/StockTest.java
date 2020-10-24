package stock.v2021.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;

@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class StockTest {

	private final ObjectMapper mapper = new ObjectMapper();

	private JsonNode productsJson;

	private Stock stock;

	@BeforeAll
	public void beforeAll() throws IOException {
		productsJson = mapper.readTree(Resources.getResource("stock.products.json"));
	}

	@BeforeEach
	public void beforeEach() {
		Products products = new ProductsImpl(productsJson);
		stock = new StockImpl(products);
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

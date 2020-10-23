package v2021;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import stock.v2021.domain.Product;
import stock.v2021.domain.Stock;
import stock.v2021.domain.impl.Brownie;
import stock.v2021.domain.impl.CakePop;
import stock.v2021.domain.impl.ConstStock;
import stock.v2021.domain.impl.Muffin;
import stock.v2021.domain.impl.Water;

public class StockTest {

	@Test
	public void test_quantity() {
		Stock stock = new ConstStock();

		assertEquals(stock.quantityOf(new Brownie()), 48);
		assertEquals(stock.quantityOf(new Muffin()), 36);
		assertEquals(stock.quantityOf(new CakePop()), 24);
		assertEquals(stock.quantityOf(new Water()), 30);
	}

	@Test
	public void test_products() {
		Stock stock = new ConstStock();

		List<Product> products = stock.products();

		assertNotNull(products);
		assertFalse(products.isEmpty());
		assertEquals(products.size(), 4);
	}

}

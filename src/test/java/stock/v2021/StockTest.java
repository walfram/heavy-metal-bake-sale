package stock.v2021;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import stock.v2021.domain.Product;
import stock.v2021.domain.Stock;
import stock.v2021.domain.stock.ConstStock;

public class StockTest {

	private final Stock stock = new ConstStock();

	@Test
	public void test_brownie() {
		Product p = stock.productByCode("B");

		assertNotNull(p);

		assertEquals(p.name(), "Brownie");
		assertEquals(p.price(), 0.65);
		assertEquals(p.code(), "B");
	}

	@Test
	public void test_muffin() {
		Product p = stock.productByCode("M");

		assertNotNull(p);

		assertEquals(p.name(), "Muffin");
		assertEquals(p.price(), 1.0);
		assertEquals(p.code(), "M");
	}

	@Test
	public void test_cakepop() {
		Product p = stock.productByCode("C");

		assertNotNull(p);

		assertEquals(p.name(), "Cake Pop");
		assertEquals(p.price(), 1.35);
		assertEquals(p.code(), "C");
	}

	@Test
	public void test_water() {
		Product p = stock.productByCode("W");

		assertNotNull(p);

		assertEquals(p.name(), "Water");
		assertEquals(p.price(), 1.5);
		assertEquals(p.code(), "W");
	}

}

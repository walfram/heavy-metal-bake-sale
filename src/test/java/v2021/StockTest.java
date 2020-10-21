package v2021;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import v2021.domain.Stock;
import v2021.domain.impl.Brownie;
import v2021.domain.impl.CakePop;
import v2021.domain.impl.ConstStock;
import v2021.domain.impl.Muffin;
import v2021.domain.impl.Water;

public class StockTest {

	@Test
	public void test_quantity() {
		Stock stock = new ConstStock();

		assertEquals(stock.quantityOf(new Brownie()), 48);
		assertEquals(stock.quantityOf(new Muffin()), 36);
		assertEquals(stock.quantityOf(new CakePop()), 24);
		assertEquals(stock.quantityOf(new Water()), 30);
	}
	

}

package v2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import stock.v2021.domain.Price;
import stock.v2021.domain.Product;
import stock.v2021.domain.Stock;
import stock.v2021.domain.impl.Brownie;
import stock.v2021.domain.impl.CakePop;
import stock.v2021.domain.impl.ConstStock;
import stock.v2021.domain.impl.Water;

public class PurchaseTest {

	@Test
	public void test_case_1() {
		Stock stock = new ConstStock();

		int qntBrownie = stock.quantityOf(new Brownie());
		int qntCakepop = stock.quantityOf(new CakePop());
		int qntWater = stock.quantityOf(new Water());

		List<Product> products = List.of(new Brownie(), new CakePop(), new Water());

		double totalPrice = new Price(products).doubleValue();
		assertEquals(totalPrice, 3.5);

		for (Product product : products) {
			stock.allocate(product);
		}

		assertEquals(stock.quantityOf(new Brownie()), qntBrownie - 1);
		assertEquals(stock.quantityOf(new CakePop()), qntCakepop - 1);
		assertEquals(stock.quantityOf(new Water()), qntWater - 1);
	}

}

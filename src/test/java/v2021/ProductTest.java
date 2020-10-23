package v2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import stock.v2021.domain.Product;
import stock.v2021.domain.impl.Brownie;
import stock.v2021.domain.impl.CakePop;
import stock.v2021.domain.impl.Muffin;
import stock.v2021.domain.impl.Water;

public class ProductTest {
	
	@Test
	public void test_brownie() {
		Product p = new Brownie();
		
		assertEquals(p.name(), "Brownie");
		assertEquals(p.price(), 0.65);
		assertEquals(p.code(), "B");
	}
	
	@Test
	public void test_muffin() {
		Product  p = new Muffin();
		
		assertEquals(p.name(), "Muffin");
		assertEquals(p.price(), 1.0);
		assertEquals(p.code(), "M");
	}
	
	@Test
	public void test_cake_pop() {
		Product p = new CakePop();
		
		assertEquals(p.name(), "Cake Pop");
		assertEquals(p.price(), 1.35);
		assertEquals(p.code(), "C");
	}
	
	@Test
	public void test_water() {
		Product p = new Water();
		
		assertEquals(p.name(), "Water");
		assertEquals(p.price(), 1.5);
		assertEquals(p.code(), "W");
	}
	
}

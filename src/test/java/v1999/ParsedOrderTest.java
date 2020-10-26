package v1999;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import stock.v2021.domain.Order;

public class ParsedOrderTest {

	@Test
	public void test_group_chars_comma_separated() {
		Order order = new ParsedOrder("BBB, MMMM, W, CC, WW, B, M", 25.0).order();
		
		assertNotNull(order.items());
		assertEquals(4, order.items().size());
		
		assertTrue(order.item("B").isPresent());
		assertEquals(order.item("B").get().quantity(), 4);
		
		assertTrue(order.item("M").isPresent());
		assertEquals(order.item("M").get().quantity(), 5);
		
		assertTrue(order.item("C").isPresent());
		assertEquals(order.item("C").get().quantity(), 2);
		
		assertTrue(order.item("W").isPresent());
		assertEquals(order.item("W").get().quantity(), 3);
	}
	
	@Test
	public void test_single_chars_comma_separated() {
		Order order = new ParsedOrder("B, B, B, M, M, C, W", 10.0).order();

		assertNotNull(order.items());
		assertEquals(4, order.items().size());

		int quantityOfB = order.items().stream().filter(i -> "B".equals(i.code())).findFirst().get().quantity();
		assertEquals(3, quantityOfB);

		int quantityOfM = order.items().stream().filter(i -> "M".equals(i.code())).findFirst().get().quantity();
		assertEquals(2, quantityOfM);

		int quantityOfC = order.items().stream().filter(i -> "C".equals(i.code())).findFirst().get().quantity();
		assertEquals(1, quantityOfC);

		int quantityOfW = order.items().stream().filter(i -> "W".equals(i.code())).findFirst().get().quantity();
		assertEquals(1, quantityOfW);
	}

}

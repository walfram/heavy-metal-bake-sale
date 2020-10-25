package stock.v2021.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Order {
	
	@JsonProperty
	private final double payment;

	@JsonProperty
	private final List<Item> items;
	
	public Order(double payment, List<Item> items) {
		this.payment = payment;
		this.items = items;
	}
	
	public double payment() {
		return 0;
	}

	public List<Item> items() {
		return items;
	}
	
}

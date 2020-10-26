package stock.v2020.domain;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

	public Order(double payment, Item... items) {
		this(payment, List.of(items));
	}

	public double payment() {
		return payment;
	}

	public List<Item> items() {
		return items;
	}

	public Optional<Item> item(String code) {
		return items.stream().filter(item -> Objects.equals(code, item.code())).findFirst();
	}

}

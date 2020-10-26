package stock.v2021.domain;

import com.fasterxml.jackson.databind.JsonNode;

public final class ConstProduct implements Product {

	private final String name;
	private final String code;
	private final double price;

	private int quantity;

	public ConstProduct(String name, String code, double price, int quantity) {
		this.name = name;
		this.code = code;
		this.price = price;
		this.quantity = quantity;
	}

	public ConstProduct(JsonNode json) {
		this(json.path("name").textValue(), json.path("code").textValue(), json.path("price").doubleValue(), json.path(
				"quantity").intValue());
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public String code() {
		return code;
	}

	@Override
	public double price() {
		return price;
	}

	@Override
	public int quantity() {
		return quantity;
	}

	@Override
	public boolean hasQuantity(int quantity) {
		return this.quantity >= quantity;
	}

	@Override
	public double priceOf(int quantity) {
		return price * quantity;
	}

	@Override
	public void removeQuantity(int remove) {
		quantity -= remove;
	}

}

package stock.v2021.domain;

import com.fasterxml.jackson.databind.JsonNode;

public final class ProductImpl implements Product {

	private final String code;
	private final String name;
	private final double price;
	private final int quantity;

	public ProductImpl(JsonNode json) {
		this(json.path("code").textValue(), json.path("name").textValue(), json.path("price").doubleValue(), json.path(
				"quantity").intValue());
	}

	public ProductImpl(String code, String name, double price, int quantity) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String code() {
		return code;
	}

	@Override
	public int quantity() {
		return quantity;
	}

	@Override
	public double price() {
		return price;
	}

	@Override
	public double priceOf(int quantity) {
		return price * quantity;
	}

}

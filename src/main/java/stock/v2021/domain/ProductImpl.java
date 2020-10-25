package stock.v2021.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public final class ProductImpl implements Product {

	@JsonProperty
	private final String code;
	
	@JsonProperty
	private final String name;
	
	@JsonProperty
	private final double price;

	private int quantity;

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

	@Override
	public void remove(int quantity) {
		this.quantity -= quantity;
	}

}

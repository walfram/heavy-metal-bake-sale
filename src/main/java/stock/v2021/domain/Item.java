package stock.v2021.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Item {

	@JsonProperty
	private final String code;

	@JsonProperty
	private final int quantity;

	public Item(String code, int quantity) {
		this.code = code;
		this.quantity = quantity;
	}

	public String code() {
		return code;
	}

	public int quantity() {
		return quantity;
	}

}

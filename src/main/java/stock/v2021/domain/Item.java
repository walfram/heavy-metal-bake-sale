package stock.v2021.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

public final class Item {

	@JsonProperty
	private final String code;

	@JsonProperty
	private final int quantity;

	public Item(String code, int quantity) {
		this.code = code;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).addValue(code).addValue(quantity).toString();
	}

	public String code() {
		return code;
	}

	public int quantity() {
		return quantity;
	}

}

package stock.v2021.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import stock.v2021.domain.Product;

public class RsProduct implements Product {

	@JsonProperty private final String name;
	@JsonProperty private final double price;
	@JsonProperty private final String code;

	@JsonCreator
	public RsProduct(@JsonProperty String name, @JsonProperty double price, @JsonProperty String code) {
		this.name = name;
		this.price = price;
		this.code = code;
	}

	public RsProduct(Product source) {
		this(source.name(), source.price(), source.code());
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public double price() {
		return price;
	}

	@Override
	public String code() {
		return code;
	}

}

package stock.v2020.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface Product {

	@JsonProperty
	String name();
	
	@JsonProperty
	String code();
	
	@JsonProperty
	double price();
	
	@JsonProperty
	int quantity();

	boolean hasQuantity(int quantity);

	double priceOf(int quantity);

	void removeQuantity(int quantity);
	
}

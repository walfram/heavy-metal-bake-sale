package stock.v2021.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface Products {

	@JsonProperty
	List<Product> products();

	void purchase(Order order);

}

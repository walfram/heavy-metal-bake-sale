package stock.v2021.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import stock.v2021.domain.exception.NotEnoughStockException;
import stock.v2021.domain.exception.ProductNotFoundException;

public interface Products {

	@JsonProperty
	List<Product> products();

	void purchase(Order order) throws ProductNotFoundException, NotEnoughStockException;

}

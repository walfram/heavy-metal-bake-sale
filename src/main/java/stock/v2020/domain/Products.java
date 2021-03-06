package stock.v2020.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import stock.v2020.domain.exception.NotEnoughMoneyException;
import stock.v2020.domain.exception.NotEnoughStockException;
import stock.v2020.domain.exception.ProductNotFoundException;

public interface Products {

	@JsonProperty
	List<Product> products();

	double purchase(Order order) throws ProductNotFoundException, NotEnoughStockException, NotEnoughMoneyException;

	int quantityOf(String code);

	double priceOf(Order order);

}

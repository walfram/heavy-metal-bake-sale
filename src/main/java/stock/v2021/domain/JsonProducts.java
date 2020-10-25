package stock.v2021.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import stock.v2021.domain.exception.NotEnoughMoneyException;
import stock.v2021.domain.exception.NotEnoughStockException;
import stock.v2021.domain.exception.ProductNotFoundException;

public class JsonProducts implements Products {

	private final List<Product> products;

	public JsonProducts(JsonNode source) {
		this.products = new ArrayList<>(source.size());
		source.forEach(json -> products.add(new ConstProduct(json)));
	}

	@Override
	public List<Product> products() {
		return products;
	}

	@Override
	public double purchase(Order order) throws ProductNotFoundException, NotEnoughStockException, NotEnoughMoneyException {
		throw new UnsupportedOperationException();
	}

	@Override
	public int quantityOf(String code) {
		throw new UnsupportedOperationException();
	}

}

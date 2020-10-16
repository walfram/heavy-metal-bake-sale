package stock.v2021.domain.stock.products;

import stock.v2021.domain.Product;

public class Brownie implements Product {

	@Override
	public String name() {
		return "Brownie";
	}

	@Override
	public double price() {
		return 0.65;
	}

	@Override
	public String code() {
		return "B";
	}

}

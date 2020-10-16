package stock.v2021.domain.stock.products;

import stock.v2021.domain.Product;

public class Water implements Product {

	@Override
	public String name() {
		return "Water";
	}

	@Override
	public double price() {
		return 1.5;
	}

	@Override
	public String code() {
		return "W";
	}

}

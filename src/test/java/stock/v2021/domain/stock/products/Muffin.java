package stock.v2021.domain.stock.products;

import stock.v2021.domain.Product;

public class Muffin implements Product {

	@Override
	public String name() {
		return "Muffin";
	}

	@Override
	public double price() {
		return 1.0;
	}

	@Override
	public String code() {
		return "M";
	}

}

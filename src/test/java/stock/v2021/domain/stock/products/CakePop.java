package stock.v2021.domain.stock.products;

import stock.v2021.domain.Product;

public class CakePop implements Product {

	@Override
	public String name() {
		return "Cake Pop";
	}

	@Override
	public double price() {
		return 1.35;
	}

	@Override
	public String code() {
		return "C";
	}

}

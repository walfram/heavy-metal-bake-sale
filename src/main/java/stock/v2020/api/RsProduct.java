package stock.v2020.api;

import v1999.domain.Product;

public final class RsProduct {

	public final String name;
	public final double price;
	public final String code;
	public final int amount;

	public RsProduct(Product product, int amount) {
		this.name = product.name();
		this.price = product.price();
		this.code = product.code();
		this.amount = amount;
	}

}

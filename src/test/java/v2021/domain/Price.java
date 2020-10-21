package v2021.domain;

import java.util.List;

public final class Price {

	private final List<Product> products;

	public Price(List<Product> products) {
		this.products = products;
	}

	public double doubleValue() {
		return products.stream().mapToDouble(p -> p.price()).sum();
	}

}

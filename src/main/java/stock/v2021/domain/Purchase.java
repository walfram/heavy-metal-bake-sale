package stock.v2021.domain;

import java.util.List;

public final class Purchase {

	private final double paid;
	private final List<ProductRequest> requested;

	public Purchase(double paid, ProductRequest... products) {
		this(paid, List.of(products));
	}

	public Purchase(double paid, List<ProductRequest> products) {
		this.paid = paid;
		this.requested = products;
	}

	public List<ProductRequest> requestedProducts() {
		return requested;
	}

	public double paid() {
		return paid;
	}

}

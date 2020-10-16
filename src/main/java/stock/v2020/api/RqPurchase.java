package stock.v2020.api;

import java.util.ArrayList;
import java.util.List;

public final class RqPurchase {

	public final double payment;

	public final List<RqProduct> products = new ArrayList<>();

	public RqPurchase(List<RqProduct> products, double payment) {
		this.products.addAll(products);
		this.payment = payment;
	}

}

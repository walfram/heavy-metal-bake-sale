package v2021.domain.impl;

import java.util.HashMap;
import java.util.Map;

import v2021.domain.Product;
import v2021.domain.Stock;

public class ConstStock implements Stock {

	private final Map<String, Integer> quantity = new HashMap<>();

	public ConstStock() {
		quantity.put(new Brownie().code(), 48);
		quantity.put(new Muffin().code(), 36);
		quantity.put(new CakePop().code(), 24);
		quantity.put(new Water().code(), 30);
	}

	@Override
	public int quantityOf(Product product) {
		return quantity.get(product.code());
	}

	@Override
	public void allocate(Product product) {
		quantity.computeIfPresent(product.code(), (String key, Integer value) -> {
			if (value - 1 >= 0)
				return value - 1;

			return null;
		});
	}

}

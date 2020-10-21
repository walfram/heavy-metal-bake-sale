package stock.v2021.domain.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import stock.v2021.domain.Product;
import stock.v2021.domain.Stock;

public class ConstStock implements Stock {

	private final Map<String, Integer> quantity = new LinkedHashMap<>();

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

	@Override
	public List<Product> products() {
		return List.of(new Brownie(), new Muffin(), new CakePop(), new Water());
	}

}

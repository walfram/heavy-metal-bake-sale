package stock.v2021.domain.stock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import stock.v2021.domain.Product;
import stock.v2021.domain.Stock;
import stock.v2021.domain.stock.products.Brownie;
import stock.v2021.domain.stock.products.CakePop;
import stock.v2021.domain.stock.products.Muffin;
import stock.v2021.domain.stock.products.Water;

public class ConstStock implements Stock {

	private final Map<String, Product> products = new HashMap<>();

	public ConstStock() {
		Arrays.asList(new Brownie(), new Muffin(), new CakePop(), new Water()).forEach(p -> products.put(p.code(), p));
	}

	@Override
	public Product productByCode(String code) {
		return products.get(code);
	}

}

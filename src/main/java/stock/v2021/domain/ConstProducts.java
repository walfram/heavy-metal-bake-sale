package stock.v2021.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ConstProducts implements Products {

	private List<Product> products = new ArrayList<>();

	public ConstProducts() {
		products.add(new ConstProduct("Brownie", "B", 0.65, 48));
		products.add(new ConstProduct("Muffin", "M", 1.0, 36));
		products.add(new ConstProduct("Cake Pop", "C", 1.35, 24));
		products.add(new ConstProduct("Water", "W", 1.5, 30));
	}

	@Override
	public List<Product> products() {
		return products;
	}

	@Override
	public void purchase(Order order) {
		for (Item item : order.items())
			
	}

}

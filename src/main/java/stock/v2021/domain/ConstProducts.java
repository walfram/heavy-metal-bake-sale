package stock.v2021.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import stock.v2021.domain.exception.NotEnoughStockException;
import stock.v2021.domain.exception.ProductNotFoundException;

@Component
public class ConstProducts implements Products {

	// private List<Product> products = new ArrayList<>();
	private final Map<String, Product> products;

	public ConstProducts() {
		this(List.of(
				new ConstProduct("Brownie", "B", 0.65, 48),
				new ConstProduct("Muffin", "M", 1.0, 36),
				new ConstProduct("Cake Pop", "C", 1.35, 24),
				new ConstProduct("Water", "W", 1.5, 30)));
	}

	public ConstProducts(List<Product> products) {
		this.products = products.stream().collect(Collectors.toMap(Product::code, p -> p));
	}

	@Override
	public List<Product> products() {
		return List.copyOf(products.values());
	}

	@Override
	public void purchase(Order order) throws ProductNotFoundException, NotEnoughStockException {
		for (Item item : order.items()) {
			if (!products.containsKey(item.code()))
				throw new ProductNotFoundException(item.code());

			Product product = products.get(item.code());

			if (!product.hasQuantity(item.quantity()))
				throw new NotEnoughStockException(item.code(), item.quantity(), product.quantity());
		}

	}

}

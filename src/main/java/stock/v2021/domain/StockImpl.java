package stock.v2021.domain;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public final class StockImpl implements Stock {

	private final Products products;

	public StockImpl(Products products) {
		this.products = products;
	}

	@Override
	public double purchase(Purchase purchase) throws NotEnoughStockException, NotEnoughMoneyException,
			ProductNotFoundException {
		for (ProductRequest req : purchase.requestedProducts()) {
			if (!products.hasProduct(req.code()))
				throw new ProductNotFoundException(req.code());

			if (!products.hasQuantity(req.code(), req.quantity()))
				throw new NotEnoughStockException(req.code(), req.quantity());
		}

		double price = products.price(purchase.requestedProducts());

		if (price > purchase.paid())
			throw new NotEnoughMoneyException(price, purchase.paid());

		purchase.requestedProducts().forEach(req -> products.remove(req.code(), req.quantity()));

		return purchase.paid() - price;
	}

	@Override
	public int quantityOf(String code) {
		return products.quantityOf(code);
	}

	@Override
	public List<Product> products() {
		return products.products();
	}

}

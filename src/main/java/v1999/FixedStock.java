package v1999;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import v1999.domain.Product;
import v1999.domain.Stock;
import v1999.domain.Transaction;

public final class FixedStock implements Stock {

	private final Map<String, Product> products = new LinkedHashMap<>();
	private final Map<String, Integer> amounts = new HashMap<>();

	public FixedStock() {
		Product brownie = new Product("Brownie", 0.65);
		products.put(brownie.code(), brownie);
		amounts.put(brownie.code(), 48);

		Product muffin = new Product("Muffin", 1.0);
		products.put(muffin.code(), muffin);
		amounts.put(muffin.code(), 36);

		Product cakepop = new Product("Cake pop", 1.35);
		products.put(cakepop.code(), cakepop);
		amounts.put(cakepop.code(), 24);

		Product water = new Product("Water", 1.5);
		products.put(water.code(), water);
		amounts.put(water.code(), 30);
	}

	@Override
	public List<Product> products() {
		return new ArrayList<>(products.values());
	}

	@Override
	public int amountOf(Product product) {
		String code = product.code();
		return amounts.get(code);
	}

	@Override
	public boolean hasEnough(Transaction transaction) {
		for (String code : transaction.codes()) {
			if (amounts.get(code) < transaction.amountOf(code))
				return false;
		}

		return true;
	}

	@Override
	public double totalPrice(Transaction transaction) {
		double total = 0;

		for (String code : transaction.codes()) {
			total += products.get(code).price() * transaction.amountOf(code);
		}

		return total;
	}

	@Override
	public void purchase(Transaction transaction) {
		for (String code : transaction.codes()) {
			int amount = amounts.get(code);
			amount -= transaction.amountOf(code);
			amounts.put(code, amount);
		}
	}

	@Override
	public List<String> validCodes() {
		return new ArrayList<>(products.keySet());
	}

}

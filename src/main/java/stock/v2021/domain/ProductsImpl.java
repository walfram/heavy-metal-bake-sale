package stock.v2021.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.databind.JsonNode;

public final class ProductsImpl implements Products {

	private final Map<String, Product> products;

	public ProductsImpl(JsonNode json) {
		this(StreamSupport.stream(json.spliterator(), false).map(ProductImpl::new).collect(Collectors.toList()));
	}

	public ProductsImpl(List<Product> products) {
		this.products = products.stream().collect(Collectors.toMap(Product::code, product -> product));
	}

	@Override
	public boolean hasProduct(String code) {
		return products.containsKey(code);
	}

	@Override
	public boolean hasQuantity(String code, int quantity) {
		if (!hasProduct(code))
			return false;

		if (products.get(code).quantity() < quantity)
			return false;

		return true;
	}

	@Override
	public void remove(String code, int quantity) {

	}

	@Override
	public double price(List<ProductRequest> requestedProducts) {
		double sum = requestedProducts.stream().filter(rp -> products.containsKey(rp.code())).mapToDouble(
				rp -> products.get(rp.code()).priceOf(rp.quantity())).sum();

		return sum;
	}

}
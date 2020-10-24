package stock.v2021.domain;

public interface Product {

	String code();

	int quantity();

	double price();

	double priceOf(int quantity);
	
}

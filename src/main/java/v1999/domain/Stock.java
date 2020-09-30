package v1999.domain;

import java.util.List;

public interface Stock {

	List<Product> products();

	int amountOf(Product product);

	boolean hasEnough(Transaction transaction);

	double totalPrice(Transaction transaction);

	void purchase(Transaction transaction);

	List<String> validCodes();

}

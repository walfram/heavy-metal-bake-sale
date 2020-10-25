package stock.v2021.domain;

import java.util.List;

public interface Products {

	boolean hasProduct(String code);
	
	boolean hasQuantity(String code, int quantity);

	void remove(String code, int quantity);

	double price(List<ProductRequest> requestedProducts);

	int quantityOf(String code);

	List<Product> products();

}

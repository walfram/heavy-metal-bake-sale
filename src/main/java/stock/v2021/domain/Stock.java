package stock.v2021.domain;

import java.util.List;

public interface Stock {

	int quantityOf(Product product);

	void allocate(Product product);

	List<Product> products();

}

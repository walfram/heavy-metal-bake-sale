package stock.v2021.domain;

import java.util.List;

public interface Stock {

	double purchase(Purchase purchase) throws NotEnoughStockException, NotEnoughMoneyException, ProductNotFoundException;

	int quantityOf(String code);

	List<Product> products();

}

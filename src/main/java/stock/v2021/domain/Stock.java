package stock.v2021.domain;

public interface Stock {

	double purchase(Purchase purchase) throws NotEnoughStockException, NotEnoughMoneyException, ProductNotFoundException;

	int quantityOf(String code);

}

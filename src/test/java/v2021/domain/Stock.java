package v2021.domain;

public interface Stock {

	int quantityOf(Product product);

	void allocate(Product product);

}

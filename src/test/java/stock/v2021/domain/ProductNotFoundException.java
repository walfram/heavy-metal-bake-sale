package stock.v2021.domain;

public class ProductNotFoundException extends Exception {

	public final String code;

	public ProductNotFoundException(String code) {
		this.code = code;
	}

	private static final long serialVersionUID = -8142910124237642517L;

}

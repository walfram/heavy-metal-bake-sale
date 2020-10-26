package stock.v2020.domain.exception;

public final class ProductNotFoundException extends Exception {

	public final String code;

	public ProductNotFoundException(String code) {
		this.code = code;
	}

	private static final long serialVersionUID = -8142910124237642517L;

}

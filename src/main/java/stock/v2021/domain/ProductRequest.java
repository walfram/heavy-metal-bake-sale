package stock.v2021.domain;

public class ProductRequest {

	private final String code;
	private final int quantity;

	public ProductRequest(String code, int quantity) {
		this.code = code;
		this.quantity = quantity;
	}

	public String code() {
		return code;
	}

	public int quantity() {
		return quantity;
	}

}

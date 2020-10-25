package stock.v2021.domain.exception;

public final class NotEnoughStockException extends Exception {

	public final String code;
	public final int quantity;

	public NotEnoughStockException(String code, int quantity) {
		this.code = code;
		this.quantity = quantity;
	}

	private static final long serialVersionUID = -6693031412377866964L;

}

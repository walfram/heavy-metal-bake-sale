package stock.v2021.domain.exception;

public final class NotEnoughStockException extends Exception {

	public final String code;
	public final int quantity;
	public final int available;

	public NotEnoughStockException(String code, int requested, int available) {
		this.code = code;
		this.quantity = requested;
		this.available = available;
	}

	private static final long serialVersionUID = -6693031412377866964L;

}
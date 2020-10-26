package stock.v2020.domain.exception;

public final class NotEnoughMoneyException extends Exception {

	public final double price;
	public final double payment;

	public NotEnoughMoneyException(double price, double payment) {
		this.price = price;
		this.payment = payment;
	}

	private static final long serialVersionUID = -5303578988672611152L;

}

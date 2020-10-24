package stock.v2021.domain;

public class NotEnoughMoneyException extends Exception {

	public final double price;
	public final double paid;

	public NotEnoughMoneyException(double price, double paid) {
		this.price = price;
		this.paid = paid;
	}

	private static final long serialVersionUID = -5303578988672611152L;

}

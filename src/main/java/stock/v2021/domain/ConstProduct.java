package stock.v2021.domain;

public final class ConstProduct implements Product {

	private final String name;
	private final String code;
	private final double price;

	private int quantity;

	public ConstProduct(String name, String code, double price, int quantity) {
		this.name = name;
		this.code = code;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public String code() {
		return code;
	}

	@Override
	public double price() {
		return price;
	}

	@Override
	public int quantity() {
		return quantity;
	}

}

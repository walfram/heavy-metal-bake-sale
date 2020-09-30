package v1999.domain;

public final class Product {

	private final String name;
	private final double price;
	private final String code;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
		this.code = name.substring(0, 1).toUpperCase();
	}

	public String name() {
		return name;
	}

	public double price() {
		return price;
	}

	public String code() {
		return code;
	}

}

package v2021.domain;

public class ProductImpl implements Product {

	private final String name;
	private final double price;
	private final String code;
	
	public ProductImpl(String name, double price, String code) {
		this.name = name;
		this.price = price;
		this.code = code;
	}
	
	@Override
	public String name() {
		return name;
	}

	@Override
	public double price() {
		return price;
	}

	@Override
	public String code() {
		return code;
	}

}

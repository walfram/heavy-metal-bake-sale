package v1999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import stock.v2020.domain.ConstProducts;
import stock.v2020.domain.Order;
import stock.v2020.domain.Product;
import stock.v2020.domain.Products;
import stock.v2020.domain.exception.NotEnoughMoneyException;
import stock.v2020.domain.exception.NotEnoughStockException;
import stock.v2020.domain.exception.ProductNotFoundException;

public class Main {

	public static void main(String[] args) {
		Main app = new Main();
		app.run();
	}

	private final Products products = new ConstProducts();

	private void run() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				System.out.println("********************************");
				System.out.println("Welcome to Heavy Metal Bake Sale");
				System.out.println("Here is what we have in stock");

				for (Product product : products.products()) {
					String s = String.format("%s - %.02f (%s)", product.name(), product.price(), product.quantity());
					System.out.println(s);
				}

				System.out.print("Items to Purchase: ");
				String items = reader.readLine();

				System.out.print("Your payment: ");
				double payment = Double.valueOf(reader.readLine());

				Order order = new ParsedOrder(items, payment).order();
				String ordered = order.items().stream().map(i -> String.format("%s:%s", i.code(), i.quantity())).collect(
						Collectors.joining(", "));
				System.out.println(String.format("ordered items: %s", ordered));
				
				double price = products.priceOf(order);
				System.out.println(String.format("Price: %.02f", price));

				try {
					double change = products.purchase(order);
					System.out.println(String.format("Change: %.02f", change));
				} catch (ProductNotFoundException e) {
					System.out.println(String.format("Product not found in stock = %s", e.code));
				} catch (NotEnoughStockException e) {
					System.out.println(
							String.format(
									"Not enough stock for product %s, requested = %d, available = %s",
									e.code,
									e.requested,
									e.available));
				} catch (NotEnoughMoneyException e) {
					System.out.println(String.format("Not enough payment, total price = %s, payment = %s", e.price, e.payment));
				}

				System.out.println();
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

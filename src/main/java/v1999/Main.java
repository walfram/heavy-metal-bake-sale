package v1999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import v1999.domain.Product;
import v1999.domain.Stock;
import v1999.domain.Transaction;
import v1999.util.ParsedCodes;

public class Main {

	public static void main(String[] args) {
		Main app = new Main();
		app.run();
	}

	private final Stock stock = new FixedStock();

	private void run() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				System.out.println("Welcome to Heavy Metal Bake Sale");
				System.out.println("Here is what we have in stock");

				for (Product product : stock.products()) {
					String s = String.format("%s - %.02f (%s)", product.name(), product.price(), stock.amountOf(product));
					System.out.println(s);
				}

				System.out.print("Items to Purchase: ");

				String items = reader.readLine();

				List<String> codes = new ParsedCodes(items).asList();

				Transaction transaction = new ValidatingTransaction(stock.validCodes(), new ParsedTransaction(codes));

				System.out.println(String.format("transaction: %s", transaction.codes()));

				if (stock.hasEnough(transaction)) {
					double total = stock.totalPrice(transaction);
					System.out.println(String.format("total %.02f", total));

					System.out.print("amount paid: ");
					double paid = Double.valueOf(reader.readLine());

					if (paid < total) {
						System.out.println("not enough money");
					} else {
						stock.purchase(transaction);
						System.out.println(String.format("change %.02f", paid - total));
					}

				} else {
					System.out.println("not enough stock");
				}

				System.out.println();
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

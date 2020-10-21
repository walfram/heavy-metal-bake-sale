package stock.v2020.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import stock.v2020.api.RqPurchase;
import stock.v2020.api.RsProduct;
import stock.v2020.transaction.JsonTransaction;
import v1999.FixedStock;
import v1999.ValidatingTransaction;
import v1999.domain.Product;
import v1999.domain.Stock;
import v1999.domain.Transaction;

@RestController
@RequestMapping("/api/v2020")
public class Stock2020Controller {

	private final Stock stock = new FixedStock();

	@GetMapping("/status")
	public List<RsProduct> status() {

		List<Product> products = stock.products();
		List<RsProduct> status = new ArrayList<>(products.size());

		for (Product p : products) {
			int amount = stock.amountOf(p);
			status.add(new RsProduct(p, amount));
		}

		return status;
	}

	@PostMapping("/purchase2")
	public ResponseEntity<?> purchase(@RequestBody RqPurchase purchase) {
		return new ResponseEntity<String>("not yet implemented", HttpStatus.NOT_IMPLEMENTED);
	}

	@Deprecated
	@PostMapping("/purchase")
	public ResponseEntity<?> purchase(@RequestBody JsonNode payload) {
		Transaction transaction = new ValidatingTransaction(stock.validCodes(), new JsonTransaction(payload));

		if (stock.hasEnough(transaction)) {
			double total = stock.totalPrice(transaction);

			double paid = payload.path("payment").doubleValue();

			if (paid < total) {
				return new ResponseEntity<String>(String.format(
						"paid amount is less then total price; paid = %.02f; total = %.02f",
						paid,
						total), HttpStatus.BAD_REQUEST);
			} else {
				stock.purchase(transaction);
				String message = String.format("success:change:%.02f", paid - total);
				return new ResponseEntity<String>(message, HttpStatus.OK);
			}

		} else {
			return new ResponseEntity<>("not enough stock", HttpStatus.CONFLICT);
		}
	}

}

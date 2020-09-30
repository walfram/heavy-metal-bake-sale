package v2020.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import v1999.FixedStock;
import v1999.ValidatingTransaction;
import v1999.domain.Stock;
import v1999.domain.Transaction;
import v2020.transaction.JsonTransaction;

@RestController
@RequestMapping("/api/v2020")
public class StockController {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(StockController.class);

	private final ObjectMapper mapper = new ObjectMapper();
	private final Stock stock = new FixedStock();

	@GetMapping("/status")
	public JsonNode status() {
		ArrayNode response = mapper.createArrayNode();

		stock.products().forEach(p -> {
			int amountOf = stock.amountOf(p);

			ObjectNode json = mapper.createObjectNode();

			json.put("product", p.name());
			json.put("code", p.code());
			json.put("price", p.price());
			json.put("stockAmount", amountOf);

			response.add(json);
		});

		return response;
	}

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

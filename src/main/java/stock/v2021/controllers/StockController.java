package stock.v2021.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stock.v2021.domain.Order;
import stock.v2021.domain.Product;
import stock.v2021.domain.Products;
import stock.v2021.domain.exception.NotEnoughMoneyException;
import stock.v2021.domain.exception.NotEnoughStockException;
import stock.v2021.domain.exception.ProductNotFoundException;

@RestController
@RequestMapping("/api/v2021/stock")
public final class StockController {

	private final Products products;

	public StockController(Products products) {
		this.products = products;
	}

	@GetMapping
	public List<Product> products() {
		return products.products();
	}

	@PostMapping
	public ResponseEntity<?> purchase(@RequestBody Order order) {
		try {
			double change = products.purchase(order);
			return new ResponseEntity<>(change, HttpStatus.ACCEPTED);
		} catch (ProductNotFoundException e) {
			return new ResponseEntity<>("product not found", HttpStatus.PRECONDITION_FAILED);
		} catch (NotEnoughStockException e) {
			return new ResponseEntity<>("not enough stock", HttpStatus.PRECONDITION_FAILED);
		} catch (NotEnoughMoneyException e) {
			return new ResponseEntity<>("not enough payment", HttpStatus.PRECONDITION_FAILED);
		}
	}

	// @GetMapping
	// public List<Product> status() {
	// return stock.products().stream().map(RsProduct::new).collect(Collectors.toList());
	// }

	// @PostMapping
	// public void purchase(@RequestBody List<ProductAmount> request) {
	// }

}
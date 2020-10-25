package stock.v2021.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stock.v2021.domain.Order;
import stock.v2021.domain.Product;
import stock.v2021.domain.Products;

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
	public void purchase(@RequestBody Order order) {
		products.purchase(order);
	}

	// @GetMapping
	// public List<Product> status() {
	// return stock.products().stream().map(RsProduct::new).collect(Collectors.toList());
	// }

	// @PostMapping
	// public void purchase(@RequestBody List<ProductAmount> request) {
	// }

}

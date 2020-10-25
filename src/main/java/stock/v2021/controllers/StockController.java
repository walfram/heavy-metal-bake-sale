package stock.v2021.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stock.v2021.domain.Product;
import stock.v2021.domain.Stock;

@RestController
@RequestMapping("/api/v2021/stock")
public final class StockController {

	private final Stock stock;

	public StockController(Stock stock) {
		this.stock = stock;
	}

	@GetMapping
	public List<Product> products() {
		return stock.products();
	}
	
	// @GetMapping
	// public List<Product> status() {
	// return stock.products().stream().map(RsProduct::new).collect(Collectors.toList());
	// }

	// @PostMapping
	// public void purchase(@RequestBody List<ProductAmount> request) {
	// }

}

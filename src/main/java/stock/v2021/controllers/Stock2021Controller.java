package stock.v2021.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stock.v2021.domain.Product;
import stock.v2021.domain.Stock;

@RestController
@RequestMapping("/api/v2021/stock")
public class Stock2021Controller {

	private final Stock stock;

	public Stock2021Controller(Stock stock) {
		this.stock = stock;
	}

	@GetMapping
	public List<Product> status() {
		return stock.products();
	}

	@PostMapping
	public void purchase(@RequestBody List<ProductAmount> request) {

	}

}

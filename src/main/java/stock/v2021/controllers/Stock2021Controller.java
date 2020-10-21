package stock.v2021.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stock.v2021.domain.Product;
import stock.v2021.domain.Stock;
import stock.v2021.domain.dto.RsProduct;

@RestController
@RequestMapping("/api/v2021/stock")
public class Stock2021Controller {

	private final Stock stock;

	public Stock2021Controller(Stock stock) {
		this.stock = stock;
	}

	@GetMapping
	public List<Product> status() {
		return stock.products().stream().map(RsProduct::new).collect(Collectors.toList());
	}

	@PostMapping
	public void purchase(@RequestBody List<ProductAmount> request) {

	}

}

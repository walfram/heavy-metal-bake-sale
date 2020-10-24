package stock.v2021.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2021/stock")
public final class Stock2021Controller {

	// public Stock2021Controller(Stock stock) {
	// this.stock = stock;
	// }

	// @GetMapping
	// public List<Product> status() {
	// return stock.products().stream().map(RsProduct::new).collect(Collectors.toList());
	// }

	// @PostMapping
	// public void purchase(@RequestBody List<ProductAmount> request) {
	// }

}

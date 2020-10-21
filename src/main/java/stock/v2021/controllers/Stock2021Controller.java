package stock.v2021.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stock.v2021.service.StockService;

@RestController
@RequestMapping("/api/v2021/stock")
public class Stock2021Controller {

	private final StockService stockService;

	public Stock2021Controller(StockService stockService) {
		this.stockService = stockService;
	}

	@GetMapping("/")
	public List<ProductAmount> status() {
		return stockService.status();
	}

	@PostMapping("/")
	public void purchase(@RequestBody List<ProductAmount> request) {
		
	}

}

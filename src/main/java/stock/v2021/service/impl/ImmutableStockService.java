package stock.v2021.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import stock.v2021.controllers.ProductAmount;
import stock.v2021.service.StockService;

@Component
public class ImmutableStockService implements StockService {

	private final List<ProductAmount> amounts = new ArrayList<>();
	
	public ImmutableStockService() {
		amounts.add(new ProductAmount());
	}
	
	@Override
	public List<ProductAmount> status() {
		return null;
	}

}

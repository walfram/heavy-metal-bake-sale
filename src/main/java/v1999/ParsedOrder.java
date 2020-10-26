package v1999;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.base.Splitter;

import stock.v2021.domain.Item;
import stock.v2021.domain.Order;

public final class ParsedOrder {

	private final String source;
	private final double payment;

	public ParsedOrder(String source, double payment) {
		this.source = source;
		this.payment = payment;
	}

	public Order order() {
		List<String> splitted = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(source);

		Map<String, Integer> codes = new LinkedHashMap<>();

		for (String s : splitted) {
			s.chars().mapToObj(c -> String.valueOf((char) c)).forEach(e -> {
				codes.compute(e, (String key, Integer val) -> {
					return val == null ? 1 : val + 1;
				});
			});
		}

		List<Item> items = codes.entrySet().stream().map(e -> new Item(e.getKey(), e.getValue())).collect(Collectors.toList());

		return new Order(payment, items);
	}

}

package v1999;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import v1999.domain.Transaction;

public final class ParsedTransaction implements Transaction {

	private final Map<String, Integer> amounts = new LinkedHashMap<>();

	public ParsedTransaction(List<String> codes) {
		Set<String> uniques = new LinkedHashSet<>(codes);

		uniques.forEach(code -> {
			int amount = Collections.frequency(codes, code);
			amounts.put(code, amount);
		});
	}

	public List<String> codes() {
		return new ArrayList<>(amounts.keySet());
	}

	public int amountOf(String code) {
		return amounts.get(code);
	}

}

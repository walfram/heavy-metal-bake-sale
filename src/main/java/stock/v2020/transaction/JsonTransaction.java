package stock.v2020.transaction;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import v1999.ParsedTransaction;
import v1999.domain.Transaction;
import v1999.util.ParsedCodes;

public final class JsonTransaction implements Transaction {

	private final Transaction delegate;

	public JsonTransaction(JsonNode json) {
		this.delegate = new ParsedTransaction(new ParsedCodes(json.path("transaction").textValue()).asList());
	}

	@Override
	public List<String> codes() {
		return delegate.codes();
	}

	@Override
	public int amountOf(String code) {
		return delegate.amountOf(code);
	}

}

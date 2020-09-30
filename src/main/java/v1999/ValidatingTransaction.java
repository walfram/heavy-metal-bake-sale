package v1999;

import java.util.List;

import v1999.domain.Transaction;

public final class ValidatingTransaction implements Transaction {

	private final List<String> validCodes;
	private final Transaction source;

	public ValidatingTransaction(List<String> validCodes, Transaction source) {
		this.validCodes = validCodes;
		this.source = source;
	}

	@Override
	public List<String> codes() {
		List<String> codes = source.codes();
		codes.retainAll(validCodes);
		return codes;
	}

	@Override
	public int amountOf(String code) {
		if (codes().contains(code))
			return source.amountOf(code);

		return 0;
	}

}

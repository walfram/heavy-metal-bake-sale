package v1999;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Splitter;

public final class ParsedItems {

	private final String input;

	public ParsedItems(String input) {
		this.input = input;
	}

	public List<String> asList() {
		return Splitter.on(",").omitEmptyStrings().trimResults().splitToStream(input).map(s -> s.substring(0, 1).toUpperCase())
				.collect(Collectors.toList());
	}

}

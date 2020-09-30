package v1999.util;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Splitter;

public final class ParsedCodes {

	private final String input;

	public ParsedCodes(String input) {
		this.input = input;
	}

	public List<String> asList() {
		return Splitter.on(",").omitEmptyStrings().trimResults().splitToStream(input).map(s -> s.substring(0, 1).toUpperCase())
				.collect(Collectors.toList());
	}

}

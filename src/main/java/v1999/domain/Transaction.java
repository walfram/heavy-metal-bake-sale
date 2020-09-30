package v1999.domain;

import java.util.List;

public interface Transaction {

	List<String> codes();

	int amountOf(String code);

}

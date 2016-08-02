package de.invidit.design.structural.bridge.internal.v1;

import de.invidit.design.structural.bridge.external.sparkasse.v2.SparkasseAccountService;
import de.invidit.design.structural.bridge.model.AccountEnquiry;
import de.invidit.design.structural.bridge.model.Accounting;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public class AccountEnquirySparkasse implements AccountEnquiry {

	@Override
	public Collection<Accounting> retrieveAccountingData(String account) {
		String accountingsJson = new SparkasseAccountService().retrieveDataForAccountAsJson(account);

		return convertAccounting(accountingsJson);
	}

	private Collection<Accounting> convertAccounting(String accountingsJson) {
		// Json conversion to AccountData collection goes here
		return new HashSet<>();
	}
}

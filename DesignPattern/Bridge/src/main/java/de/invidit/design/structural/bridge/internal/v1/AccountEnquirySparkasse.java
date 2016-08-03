package de.invidit.design.structural.bridge.internal.v1;

import de.invidit.design.structural.bridge.external.sparkasse.v2.AccountingJsonConverter;
import de.invidit.design.structural.bridge.external.sparkasse.v2.SparkasseAccountService;
import de.invidit.design.structural.bridge.internal.AccountEnquiry;
import de.invidit.design.structural.bridge.model.Accounting;

import java.util.Collection;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public class AccountEnquirySparkasse extends AccountEnquiry {

    public AccountEnquirySparkasse() {
        super(new SparkasseAccountService(new AccountingJsonConverter()));
    }

    @Override
	public Collection<Accounting> retrieveAccountingData(String account) {
		return bankService.retrieveDataForAccount(account);
	}
}

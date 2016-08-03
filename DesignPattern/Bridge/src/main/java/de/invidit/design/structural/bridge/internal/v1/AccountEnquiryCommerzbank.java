package de.invidit.design.structural.bridge.internal.v1;

import de.invidit.design.structural.bridge.external.commerzbank.v1.AccountingConverter;
import de.invidit.design.structural.bridge.external.commerzbank.v1.CommerzbankAccountService;
import de.invidit.design.structural.bridge.internal.AccountEnquiry;
import de.invidit.design.structural.bridge.model.Accounting;

import java.util.Collection;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public class AccountEnquiryCommerzbank extends AccountEnquiry {

    public AccountEnquiryCommerzbank() {
        super(new CommerzbankAccountService(new AccountingConverter()));
    }

    @Override
    public Collection<Accounting> retrieveAccountingData(String accountNo) {
	  return bankService.retrieveDataForAccount(accountNo);
    }
}

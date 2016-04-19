package de.invidit.design.structural.adapter;

import de.invidit.design.structural.adapter.external.SparkasseAccountService;
import de.invidit.design.structural.adapter.model.AccountEnquiry;
import de.invidit.design.structural.adapter.model.Accounting;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author Torsten Mingers
 * @since 18.04.2016
 */
public class AccountEnquirySparkasse implements AccountEnquiry {

    @Override
    public Collection<Accounting> retrieveAccountingData(String account) {
        String accountingsJson = new SparkasseAccountService().retrieveDataForAccountAsJson(account);

        return convertAccounting(accountingsJson);
    }

    private Collection<Accounting> convertAccounting(String accountingsJson) {
        // Json conversion to Accounting collection goes here
        return new HashSet<>();
    }
}

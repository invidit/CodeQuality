package de.invidit.design.structural.bridge.internal.v1;

import de.invidit.design.structural.bridge.external.commerzbank.v1.AccountingConverter;
import de.invidit.design.structural.bridge.external.commerzbank.v1.CommerzbankAccountService;
import de.invidit.design.structural.bridge.model.AccountEnquiry;
import de.invidit.design.structural.bridge.model.Accounting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public class AccountEnquiryCommerzbank implements AccountEnquiry {

    @Override
    public Collection<Accounting> retrieveAccountingData(String accountNo) {
	    AccountingConverter accountDataConverter = new AccountingConverter();
	    List<Accounting> accountings = new CommerzbankAccountService(accountDataConverter)
		                                .retrieveDataForAccount(accountNo);
        return convertAccounting(accountings);
    }

    private Collection<Accounting> convertAccounting(List<Accounting> accountings) {
        ArrayList<Accounting> convertedAccountings = new ArrayList<>();

        for (Accounting accountingSequence : accountings) {
            Accounting accounting = Accounting.builder()
		            .Absender(accountingSequence.getAbsender())
                    .Empfaenger(accountingSequence.getEmpfaenger())
                    .SollHabenKennzeichen(accountingSequence.getSollHabenKennzeichen())
                    .Betrag(Double.parseDouble(accountingSequence.getText()))
                    .Text(accountingSequence.getText())
                    .build();

            convertedAccountings.add(accounting);
        }
        return convertedAccountings;
    }
}

package de.invidit.design.structural.adapter;

import de.invidit.design.structural.adapter.model.AccountEnquiry;
import de.invidit.design.structural.adapter.model.Accounting;
import de.invidit.design.structural.adapter.external.CommerzbankAccountService;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Torsten Mingers
 * @since 18.04.2016
 */
public class AccountEnquiryCommerzbank implements AccountEnquiry{

    @Override
    public Collection<Accounting> retrieveAccountingData(String accountNo) {
        String[][] accountings = new CommerzbankAccountService().retrieveDataForAccount(accountNo);

        return convertAccounting(accountings);
    }

    private Collection<Accounting> convertAccounting(String[][] accountings) {
        ArrayList<Accounting> convertedAccountings = new ArrayList<>();

        for (String[] accountingSequence : accountings) {
            Accounting accounting = Accounting.builder().Absender(accountingSequence[0])
                    .Empfaenger(accountingSequence[1])
                    .SollHabenKennzeichen(accountingSequence[2].charAt(0))
                    .Betrag(Double.parseDouble(accountingSequence[3]))
                    .Text(accountingSequence[4])
                    .build();

            convertedAccountings.add(accounting);
        }
        return convertedAccountings;
    }
}

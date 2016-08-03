package de.invidit.design.structural.bridge.external.commerzbank.v2;

import de.invidit.design.structural.bridge.external.commerzbank.v2.model.AccountData;
import de.invidit.design.structural.bridge.model.Accounting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public class AccountingConverter {

    List<Accounting> convertToAccounting(List<AccountData> accountDataList) {

        ArrayList<Accounting> convertedAccountings = new ArrayList<>();

        for (AccountData accountData : accountDataList) {
            Accounting accounting = Accounting.builder()
                    .Absender(accountData.Absender)
                    .Empfaenger(accountData.Empfaenger)
                    .SollHabenKennzeichen(accountData.SollHabenKennzeichen)
                    .Betrag(accountData.Betrag)
                    .Text(accountData.Text)
                    .build();

            convertedAccountings.add(accounting);
        }

        return convertedAccountings;
    }
}

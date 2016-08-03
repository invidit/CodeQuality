package de.invidit.design.structural.bridge.external.sparkasse.v2;

import de.invidit.design.structural.bridge.model.Accounting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public class AccountingJsonConverter {

    public List<Accounting> convertToAccounting(String accountData) {
        ArrayList<Accounting> accountings = new ArrayList<>();

        accountData = accountData.replace("{", "").replace("}", "");
        String[] tuples = accountData.split(",");
        String[] accountDataValues = new String[5];

        for (int i = 0; i < tuples.length; i++) {
            String tuple = tuples[i];
            String[] valuePair = tuple.split(":");
            accountDataValues[i] = valuePair[1].replace("\"", "").trim();
        }
        Accounting accounting = Accounting.builder()
                .Absender(accountDataValues[0])
                .Empfaenger(accountDataValues[1])
                .SollHabenKennzeichen(accountDataValues[2].charAt(0))
                .Betrag(Double.valueOf(accountDataValues[3]))
                .Text(accountDataValues[4])
                .build();
        accountings.add(accounting);

        return accountings;
    }
}

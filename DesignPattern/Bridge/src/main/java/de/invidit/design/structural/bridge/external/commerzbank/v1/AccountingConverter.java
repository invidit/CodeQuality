package de.invidit.design.structural.bridge.external.commerzbank.v1;


import de.invidit.design.structural.bridge.model.Accounting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public class AccountingConverter {

	public List<Accounting> convertToAccounting(String[][] accountingData) {
        ArrayList<Accounting> convertedAccountings = new ArrayList<>();

        for (String[] accountingSequence : accountingData) {
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

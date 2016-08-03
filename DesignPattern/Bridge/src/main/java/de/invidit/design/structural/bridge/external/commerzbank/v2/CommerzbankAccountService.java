package de.invidit.design.structural.bridge.external.commerzbank.v2;

import de.invidit.design.structural.bridge.external.BankService;
import de.invidit.design.structural.bridge.external.commerzbank.v2.model.AccountData;
import de.invidit.design.structural.bridge.model.Accounting;

import java.util.Collections;
import java.util.List;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
// would be an interface in a real world
public class CommerzbankAccountService implements BankService {

    private de.invidit.design.structural.bridge.external.commerzbank.v2.AccountingConverter accountDataConverter;

    public CommerzbankAccountService(de.invidit.design.structural.bridge.external.commerzbank.v2.AccountingConverter accountDataConverter) {
        this.accountDataConverter = accountDataConverter;
    }

    private List<AccountData> retrieveDataForAccountFromExternal(String account) {
        AccountData accountData = AccountData.builder()
                .Absender("Max Mustermann")
                .Empfaenger("Commerzbank V2")
                .SollHabenKennzeichen('S')
                .Betrag(447.25)
                .Text("Miete")
                .build();

        return Collections.singletonList(accountData);
    }

    public List<Accounting> retrieveDataForAccount(String account) {
        return accountDataConverter.convertToAccounting(retrieveDataForAccountFromExternal(account));
	}

}

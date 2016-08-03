package de.invidit.design.structural.bridge.external.commerzbank.v1;

import de.invidit.design.structural.bridge.external.BankService;
import de.invidit.design.structural.bridge.model.Accounting;

import java.util.List;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public class CommerzbankAccountService implements BankService {

	private AccountingConverter accountDataConverter;

	public CommerzbankAccountService(AccountingConverter accountDataConverter) {
		this.accountDataConverter = accountDataConverter;
	}

	private String[][] retrieveDataForAccountFromExternal(String account) {
        String[][] accountData = new String[1][5];

        accountData[0][0] = "Max Mustermann";
        accountData[0][1] = "Commerzbank V1";
        accountData[0][2] = "Soll";
        accountData[0][3] = "447.25";
        accountData[0][4] = "Miete";

        return accountData;
    }

	public List<Accounting> retrieveDataForAccount(String account) {
		return accountDataConverter.convertToAccounting(retrieveDataForAccountFromExternal(account));
	}
}

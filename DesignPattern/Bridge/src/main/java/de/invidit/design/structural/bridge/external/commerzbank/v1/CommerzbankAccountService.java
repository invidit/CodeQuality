package de.invidit.design.structural.bridge.external.commerzbank.v1;

import de.invidit.design.structural.bridge.external.BankService;
import de.invidit.design.structural.bridge.model.Accounting;

import java.util.List;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public class CommerzbankAccountService extends BankService {

	private AccountingConverter accountDataConverter;

	public CommerzbankAccountService(AccountingConverter accountDataConverter) {
		this.accountDataConverter = accountDataConverter;
	}

	private String[][] retrieveDataForAccountFromExternal(String account) {
         return new String[10][5];
     }

	@Override
	public List<Accounting> retrieveDataForAccount(String account) {
		return accountDataConverter.convertToAccounting(retrieveDataForAccountFromExternal(account));
	}
}

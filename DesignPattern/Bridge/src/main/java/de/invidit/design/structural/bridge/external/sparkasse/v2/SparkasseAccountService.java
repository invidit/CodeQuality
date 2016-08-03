package de.invidit.design.structural.bridge.external.sparkasse.v2;

import de.invidit.design.structural.bridge.external.BankService;
import de.invidit.design.structural.bridge.model.Accounting;

import java.util.List;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
// would be an interface in a real world
public class SparkasseAccountService implements BankService{

    private AccountingJsonConverter accountingConverter;

    public SparkasseAccountService(AccountingJsonConverter accountingConverter) {
        this.accountingConverter = accountingConverter;
    }

    private String retrieveDataForAccountAsJson(String account) {
		 return "{ \"Absender\" : \"Max Mustermann\","
                 + "\"Empfaenger\" : \"Sparkasse V2\","
                 + "\"SollHabenKennzeichen\" : \"S\","
                 + "\"Betrag\" : 447.25,"
                 + "\"Text\" : \"Miete\" }";
    }

    public List<Accounting> retrieveDataForAccount(String account) {
        return accountingConverter.convertToAccounting(retrieveDataForAccountAsJson(account));

    }
}

package de.invidit.design.structural.bridge.internal;

import de.invidit.design.structural.bridge.external.BankService;
import de.invidit.design.structural.bridge.model.Accounting;

import java.util.Collection;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public abstract class AccountEnquiry {
    protected BankService bankService;

    public AccountEnquiry(BankService bankService) {
        this.bankService = bankService;
    }

	public abstract Collection<Accounting> retrieveAccountingData(String account);
}

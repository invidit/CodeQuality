package de.invidit.design.structural.bridge.internal.v2;

import de.invidit.design.structural.bridge.external.commerzbank.v2.AccountingConverter;
import de.invidit.design.structural.bridge.external.commerzbank.v2.CommerzbankAccountService;
import de.invidit.design.structural.bridge.internal.AccountEnquiry;
import de.invidit.design.structural.bridge.model.Accounting;

import java.util.Collection;
import java.util.List;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public class AccountEnquiryCommerzbank extends AccountEnquiry {


	private CategoryDetermininationService categoryService;

	public AccountEnquiryCommerzbank(CategoryDetermininationService categoryService) {
        super(new CommerzbankAccountService(new AccountingConverter()));
        this.categoryService = categoryService;
	}

	public Collection<Accounting> retrieveAccountingData(String accountNo) {
        List<Accounting> accountings = bankService.retrieveDataForAccount(accountNo);

        accountings.forEach(accounting -> accounting.setKategorie(categoryService.determineCategoryByAccountingText(accounting.getText())));

        return accountings;
    }
}

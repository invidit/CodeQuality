package de.invidit.design.structural.bridge.internal.v2;

import de.invidit.design.structural.bridge.external.sparkasse.v2.AccountingJsonConverter;
import de.invidit.design.structural.bridge.external.sparkasse.v2.SparkasseAccountService;
import de.invidit.design.structural.bridge.internal.AccountEnquiry;
import de.invidit.design.structural.bridge.model.Accounting;

import java.util.Collection;
import java.util.List;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public class AccountEnquirySparkasse extends AccountEnquiry {

	private CategoryDetermininationService categoryDetermininationService;

	public AccountEnquirySparkasse(CategoryDetermininationService categoryDetermininationService) {
        super(new SparkasseAccountService(new AccountingJsonConverter()));
        this.categoryDetermininationService = categoryDetermininationService;
	}

    public Collection<Accounting> retrieveAccountingData(String accountNo) {
        List<Accounting> accountings = bankService.retrieveDataForAccount(accountNo);

        accountings.forEach(accounting -> accounting.setKategorie(categoryDetermininationService.determineCategoryByAccountingText(accounting.getText())));

        return accountings;
    }
}

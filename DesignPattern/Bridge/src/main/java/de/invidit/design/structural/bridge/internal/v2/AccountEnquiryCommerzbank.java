package de.invidit.design.structural.bridge.internal.v2;

import de.invidit.design.structural.bridge.external.commerzbank.v2.CommerzbankAccountService;
import de.invidit.design.structural.bridge.external.commerzbank.v2.model.AccountData;
import de.invidit.design.structural.bridge.model.AccountEnquiry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public class AccountEnquiryCommerzbank implements AccountEnquiry {


	private CategoryDermininationService categoryService;

	public AccountEnquiryCommerzbank(CategoryDermininationService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public Collection<de.invidit.design.structural.bridge.model.Accounting> retrieveAccountingData(String accountNo) {
		List<AccountData> accountings = new CommerzbankAccountService().retrieveDataForAccount(accountNo);

		return convertAccounting(accountings);
	}

	private Collection<de.invidit.design.structural.bridge.model.Accounting> convertAccounting(List<AccountData> accountings) {
		ArrayList<de.invidit.design.structural.bridge.model.Accounting> convertedAccountings = new ArrayList<>();

		for (AccountData accountingSequence : accountings) {
			de.invidit.design.structural.bridge.model.Accounting accounting = de.invidit.design.structural.bridge.model.Accounting.builder()
					.Absender(accountingSequence.Absender)
					.Empfaenger(accountingSequence.Empfaenger)
					.SollHabenKennzeichen(accountingSequence.SollHabenKennzeichen)
					.Betrag(accountingSequence.Betrag)
					.Text(accountingSequence.Text)
					.Kategorie(categoryService.determineCategoryByAccountingText(accountingSequence.Text))
					.build();

			convertedAccountings.add(accounting);
		}
		return convertedAccountings;
	}
}

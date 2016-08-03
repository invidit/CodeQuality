package de.invidit.design.structural.bridge;

import de.invidit.design.structural.bridge.internal.v2.AccountEnquiryCommerzbank;
import de.invidit.design.structural.bridge.internal.v2.AccountEnquirySparkasse;
import de.invidit.design.structural.bridge.internal.v2.CategoryDermininationService;
import de.invidit.design.structural.bridge.model.AccountEnquiry;
import de.invidit.design.structural.bridge.model.Accounting;

import java.util.Collection;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public class Main {
	private static CategoryDermininationService categoryService = new CategoryDermininationService();

	public static void main(String...args) {

    	switch (APIConfiguration.APIVersion) {
		    case "V1":
		    	handleEnquiryV1();
		    case "V2":
			    handleEnquiryV2();
        }
    }

	private static void handleEnquiryV1() {
		System.out.println("Enquiry Commerzbank:");
		AccountEnquiry enquiry = new de.invidit.design.structural.bridge.internal.v1
									.AccountEnquiryCommerzbank();
		Collection<Accounting> accountingsCommerzbank = enquiry.retrieveAccountingData("4711");

		System.out.println("Enquiry Sparkasse:");
		enquiry = new de.invidit.design.structural.bridge.internal.v1
									.AccountEnquirySparkasse();
		Collection<Accounting> accountingsSparkasse = enquiry.retrieveAccountingData("4711");
	}

	private static void handleEnquiryV2() {
		System.out.println("Enquiry Commerzbank:");
		AccountEnquiry enquiry = new AccountEnquiryCommerzbank(categoryService);
		Collection<Accounting> accountingsCommerzbank = enquiry.retrieveAccountingData("4711");

		System.out.println("Enquiry Sparkasse:");
		enquiry = new AccountEnquirySparkasse(categoryService);
		Collection<Accounting> accountingsSparkasse = enquiry.retrieveAccountingData("4711");
	}


}

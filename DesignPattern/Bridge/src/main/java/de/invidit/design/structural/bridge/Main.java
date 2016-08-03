package de.invidit.design.structural.bridge;

import de.invidit.design.structural.bridge.internal.AccountEnquiry;
import de.invidit.design.structural.bridge.internal.v2.CategoryDetermininationService;
import de.invidit.design.structural.bridge.model.Accounting;

import java.util.Collection;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public class Main {
	private static CategoryDetermininationService categoryService = new CategoryDetermininationService();

	public static void main(String...args) {

	    APIConfiguration.APIVersion = "V1";
        handleEnquiry();

        APIConfiguration.APIVersion = "V2";
        handleEnquiry();
    }

    private static void handleEnquiry() {
        switch (APIConfiguration.APIVersion) {
            case "V1":
                handleEnquiryV1();
                break;
            case "V2":
                handleEnquiryV2();
                break;
            default:
                throw new IllegalArgumentException("Version " + APIConfiguration.APIVersion + " is not yet supported.");
        }
    }

    private static void handleEnquiryV1() {
		System.out.println("Handling interface V1:");
		System.out.println("Enquiry Commerzbank:");
		AccountEnquiry enquiry = new de.invidit.design.structural.bridge.internal.v1
									.AccountEnquiryCommerzbank();
		Collection<Accounting> accountingsCommerzbank = enquiry.retrieveAccountingData("4711");
        System.out.println(accountingsCommerzbank);

        System.out.println("Enquiry Sparkasse:");
        enquiry = new de.invidit.design.structural.bridge.internal.v1
									.AccountEnquirySparkasse();
        Collection<Accounting> accountingsSparkasse = enquiry.retrieveAccountingData("4711");
        System.out.println(accountingsSparkasse);
    }

	private static void handleEnquiryV2() {
        System.out.println("Handling interface V2:");
		System.out.println("Enquiry Commerzbank:");
		AccountEnquiry enquiry = new de.invidit.design.structural.bridge.internal.v2
                                    .AccountEnquiryCommerzbank(categoryService);
		Collection<Accounting> accountingsCommerzbank = enquiry.retrieveAccountingData("4711");
        System.out.println(accountingsCommerzbank);

        System.out.println("Enquiry Sparkasse:");
		enquiry = new de.invidit.design.structural.bridge.internal.v2
                                    .AccountEnquirySparkasse(categoryService);
		Collection<Accounting> accountingsSparkasse = enquiry.retrieveAccountingData("4711");
        System.out.println(accountingsSparkasse);

    }

}

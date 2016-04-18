package de.invidit.design.structural.adapter;

import de.invidit.design.structural.adapter.model.AccountEnquiry;
import de.invidit.design.structural.adapter.model.Accounting;

import java.util.Collection;

/**
 * @author Torsten Mingers
 * @since 18.04.2016
 */
public class Main {
    public static void main(String...args) {

        System.out.println("Enquiry Commerzbank:");
        AccountEnquiry enquiry = new AccountEnquiryCommerzbank();
        Collection<Accounting> accountingsCommerzbank = enquiry.retrieveAccountingData("4711");

        System.out.println("Enquiry Sparkasse:");
        enquiry = new AccountEnquirySparkasse();
        Collection<Accounting> accountingsSparkasse = enquiry.retrieveAccountingData("4711");
    }
}

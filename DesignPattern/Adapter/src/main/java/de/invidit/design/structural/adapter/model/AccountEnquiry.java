package de.invidit.design.structural.adapter.model;

import java.util.Collection;

/**
 * @author Torsten Mingers
 * @since 18.04.2016
 */
public interface AccountEnquiry {
    Collection<Accounting> retrieveAccountingData(String account);
}

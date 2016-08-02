package de.invidit.design.structural.bridge.model;

import java.util.Collection;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public interface AccountEnquiry {
	Collection<Accounting> retrieveAccountingData(String account);
}

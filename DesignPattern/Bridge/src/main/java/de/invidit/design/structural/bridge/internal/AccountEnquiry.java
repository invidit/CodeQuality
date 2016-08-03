package de.invidit.design.structural.bridge.internal;

import de.invidit.design.structural.bridge.model.Accounting;

import java.util.Collection;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public interface AccountEnquiry {
	Collection<Accounting> retrieveAccountingData(String account);
}

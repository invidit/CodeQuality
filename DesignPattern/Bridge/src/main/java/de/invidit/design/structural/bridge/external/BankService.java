package de.invidit.design.structural.bridge.external;


import de.invidit.design.structural.bridge.model.Accounting;

import java.util.List;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
public interface BankService {
	List<Accounting> retrieveDataForAccount(String account);
}

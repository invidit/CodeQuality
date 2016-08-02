package de.invidit.design.structural.bridge.external.commerzbank.v2;

import de.invidit.design.structural.bridge.external.commerzbank.v2.model.AccountData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
// would be an interface in a real world
public class CommerzbankAccountService {

	public List<AccountData> retrieveDataForAccount(String account) {
		return new ArrayList<AccountData>();
	}

}

package de.invidit.design.structural.bridge.external.commerzbank.v2.model;

import lombok.Builder;

/**
 * @author Torsten Mingers
 * @since 02.08.2016
 */
@Builder
public class AccountData {
	public String Absender;
	public String Empfaenger;
	public char SollHabenKennzeichen;
	public double Betrag;
	public String Text;
}

package de.invidit.design.structural.adapter.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author Torsten Mingers
 * @since 18.04.2016
 */
@Data
@Builder
public class Accounting {
    private String Absender;
    private String Empfaenger;
    private char SollHabenKennzeichen;
    private double Betrag;
    private String Text;
}

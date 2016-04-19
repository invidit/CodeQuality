package de.invidit.design.structural.composite;

/**
 * @author Michael Weber
 * @since 19.04.2016
 */
public interface ComputingStrategie {
    double compute(Computable firstOperand, Computable secondOperand);
}

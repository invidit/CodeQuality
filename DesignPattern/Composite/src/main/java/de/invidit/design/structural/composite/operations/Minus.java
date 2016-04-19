package de.invidit.design.structural.composite.operations;

import de.invidit.design.structural.composite.Computable;
import de.invidit.design.structural.composite.ComputingStrategie;

/**
 * @author Michael Weber
 * @since 19.04.2016
 */
public class Minus implements ComputingStrategie {
    @Override
    public double compute(Computable firstOperand, Computable secondOperand) {
        return firstOperand.compute() - secondOperand.compute();
    }
}

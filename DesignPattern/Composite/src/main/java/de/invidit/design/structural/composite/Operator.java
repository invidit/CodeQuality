package de.invidit.design.structural.composite;

/**
 * @author Michael Weber
 * @since 19.04.2016
 */
public class Operator implements Computable {

    private ComputingStrategie computingStrategie;
    private Computable firstOperand;
    private Computable secondOperand;

    public Operator(Computable firstOperand, ComputingStrategie computingStrategie, Computable secondOperand) {
        this.computingStrategie = computingStrategie;
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    @Override
    public double compute() {
        return this.computingStrategie.compute(firstOperand, secondOperand);
    }
}

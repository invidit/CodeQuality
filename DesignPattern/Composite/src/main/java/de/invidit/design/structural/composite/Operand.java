package de.invidit.design.structural.composite;

/**
 * @author Michael Weber
 * @since 19.04.2016
 */
public class Operand implements Computable {

    private double value;

    public Operand(double value) {
        this.value = value;
    }

    @Override
    public double compute() {
        return this.value;
    }
}

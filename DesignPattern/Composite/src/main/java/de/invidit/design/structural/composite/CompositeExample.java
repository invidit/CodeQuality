package de.invidit.design.structural.composite;

import de.invidit.design.structural.composite.operations.Division;
import de.invidit.design.structural.composite.operations.Multiplication;
import de.invidit.design.structural.composite.operations.Plus;

/**
 * @author Michael Weber
 * @since 19.04.2016
 */
public class CompositeExample {
    public static void main(String...args) {
        Operand five = new Operand(5d);
        Operand four = new Operand(4d);
        Operand two = new Operand(2d);

        Operator fivePlusFour = new Operator(five, new Plus(), four);
        Operator twoTimesNine = new Operator(two, new Multiplication(), fivePlusFour);
        Operator eighteenDividedByFour = new Operator(twoTimesNine, new Division(), four);

        System.out.print("(5 + 4) * 2 / 4 = ");
        System.out.println(eighteenDividedByFour.compute());
    }
}

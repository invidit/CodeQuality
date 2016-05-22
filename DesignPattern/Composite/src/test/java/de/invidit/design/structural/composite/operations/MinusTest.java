package de.invidit.design.structural.composite.operations;

import de.invidit.design.structural.composite.ComputingStrategie;
import de.invidit.design.structural.composite.Operand;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.Test;

/**
 * @author Michael Weber
 * @since 19.04.2016
 */
public class MinusTest {
    @Test
    public void testComputeCalcsCorrectWithoutDecimalValues() throws Exception {
        Operand five = new Operand(5d);
        Operand four = new Operand(4d);

        ComputingStrategie sut = new Minus();
        Assertions.assertThat(sut.compute(five, four)).isEqualTo(1d, Offset.offset(0.0));
    }
}
package de.invidit.design.structural.composite.operations;

import de.invidit.design.structural.composite.ComputingStrategie;
import de.invidit.design.structural.composite.Operand;
import de.invidit.design.structural.composite.Operator;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Michael Weber
 * @since 19.04.2016
 */
public class PlusTest {

    @Test
    public void testComputeCalcsCorrectWithoutDecimalValues() throws Exception {
        Operand five = new Operand(5d);
        Operand four = new Operand(4d);

        ComputingStrategie sut = new Plus();
        Assertions.assertThat(sut.compute(five, four)).isEqualTo(9d, Offset.offset(0.0));
    }
}
package de.invidit.design.structural.decorator;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Michael Weber
 * @since 29.03.2016
 */
public class NoNameSimpleDishwasherTest {

    @Test
    public void testClearOutReturnNothingOfNotLoadedBefore() throws Exception {
        Dishwasher sut = new NoNameSimpleDishwasher();
        Assertions.assertThat(sut.clearOut()).isEmpty();
    }
}
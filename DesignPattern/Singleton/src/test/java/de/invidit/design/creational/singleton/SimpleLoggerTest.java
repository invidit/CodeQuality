package de.invidit.design.creational.singleton;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author Torsten Mingers
 * @since 05.03.2016
 */
public class SimpleLoggerTest {


    @Test
    public void testGetLoggerGivesOnlyOneObject() throws Exception {
        SimpleLogger logger = SimpleLogger.getLogger();
        Assertions.assertThat(SimpleLogger.getLogger()).isEqualTo(logger);
    }
}
package de.invidit.design.creational.singleton;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author Torsten Mingers
 * @since 05.03.2016
 */
public class PartialSynchronizedLoggerTest {
    @Test
    public void testGetLoggerGivesOnlyOneObject() throws Exception {
        PartialSynchronizedLogger logger = PartialSynchronizedLogger.getLogger();
        Assertions.assertThat(PartialSynchronizedLogger.getLogger()).isEqualTo(logger);
    }
}
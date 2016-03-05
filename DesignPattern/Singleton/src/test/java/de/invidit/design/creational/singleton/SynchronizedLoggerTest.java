/*
 * Copyright (c) 2016. InvidIT.de
 */

package de.invidit.design.creational.singleton;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author Michael Weber
 * @since 24.02.2016
 */
public class SynchronizedLoggerTest {

    @Test
    public void testGetLoggerGivesOnlyOneObject() throws Exception {
        SynchronizedLogger logger = SynchronizedLogger.getLogger();
        Assertions.assertThat(SynchronizedLogger.getLogger()).isEqualTo(logger);
    }
}
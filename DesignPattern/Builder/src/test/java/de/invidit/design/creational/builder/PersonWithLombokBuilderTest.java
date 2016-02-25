/*
 * Copyright (c) 2016. InvidIT.de
 */

package de.invidit.design.creational.builder;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author Michael Weber
 * @since 23.02.2016
 */
public class PersonWithLombokBuilderTest {
    @Test
    public void testBuilder() throws Exception {
        String name = "Name";
        String surname = "Surname";
        PersonWithLombokBuilder actual = PersonWithLombokBuilder.builder().name(name).surname(surname).build();

        Assertions.assertThat(actual.getName()).isEqualTo(name);
        Assertions.assertThat(actual.getSurname()).isEqualTo(surname);
    }
}
/*
 * Copyright (c) 2016. InviditIT.de
 */

package de.invidit.design.creational.builder;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author Michael Weber
 * @since 23.02.2016
 */
public class PersonWithSelfImplementedBuilderTest {
    @Test
    public void testBuilder() throws Exception {
        String name = "Name";
        String surname = "Surname";

        PersonWithSelfImplementedBuilder.Builder builder = new PersonWithSelfImplementedBuilder.Builder();
        PersonWithSelfImplementedBuilder actual = builder.withName(name).withSurname(surname).build();
        Assertions.assertThat(actual.getName()).isEqualTo(name);
        Assertions.assertThat(actual.getSurname()).isEqualTo(surname);
    }
}
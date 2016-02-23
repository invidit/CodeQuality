/*
 * Copyright (c) 2016. InvidIT.de
 */

package de.invidit.design.creational.builder;

import lombok.Builder;
import lombok.Data;

/**
 * @author Michael Weber
 * @since 23.02.2016
 */

@Data
@Builder
public class PersonWithLombokBuilder {
    private String name;
    private String surname;
}

/*
 * Copyright (c) 2016, invidIT. All rights reserved.
 * Use is subject to license terms.
 */

package de.invidit.design.creational.abstractfactory;

/**
 * @author Michael Weber
 * @since 19.02.2016.
 */
public class HouseFactoryDecider {
    public HouseFactory createRequiredFactory(HouseType houseType) {
        HouseFactory factory;

        switch (houseType) {
            case TreeHouse:
                factory = new TreeHouseFactory();
                break;
            case CountryHouse:
                factory = new CountryHouseFactory();
                break;
            default:
                throw new IllegalArgumentException("No such house type supported.");

        }

        return factory;
    }
}

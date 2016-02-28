/*
 * Copyright (c) 2016, invidIT. All rights reserved.
 * Use is subject to license terms.
 */

package de.invidit.design.creational.abstractfactory;

import de.invidit.design.creational.abstractfactory.component.*;

/**
 * @author Michael Weber
 * @since 19.02.2016.
 */
public class CountryHouseFactory extends HouseFactory {
    @Override
    public Door createDoor() {
        return new WoodenDoor();
    }

    @Override
    public Wall createWall() {
        return new WoodenWall();
    }

    @Override
    public Roof createRoof() {
        return new WoodenRoof();
    }
}

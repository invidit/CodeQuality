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
public class TreeHouseFactory extends HouseFactory {
    @Override
    Door createDoor() {
        return new NoDoor();
    }

    @Override
    Wall createWall() {
        return new WoodenWall();
    }

    @Override
    Roof createRoof() {
        return new WoodenRoof();
    }
}

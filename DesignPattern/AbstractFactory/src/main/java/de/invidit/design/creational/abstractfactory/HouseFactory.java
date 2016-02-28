/*
 * Copyright (c) 2016, invidIT. All rights reserved.
 * Use is subject to license terms.
 */

package de.invidit.design.creational.abstractfactory;

import de.invidit.design.creational.abstractfactory.component.Door;
import de.invidit.design.creational.abstractfactory.component.Roof;
import de.invidit.design.creational.abstractfactory.component.Wall;

/**
 * @author Michael Weber
 * @since 19.02.2016.
 */
public abstract class HouseFactory {
    public abstract Door createDoor();

    public abstract Wall createWall();

    public abstract Roof createRoof();
}

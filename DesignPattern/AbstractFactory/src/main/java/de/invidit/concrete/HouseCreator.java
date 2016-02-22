/*
 * Copyright (c) 2016, invidIT. All rights reserved.
 * Use is subject to license terms.
 */

package de.invidit.concrete;

import de.invidit.design.creational.abstractfactory.HouseType;
import de.invidit.design.creational.abstractfactory.component.*;

/**
 * @author Torsten Mingers
 */
public class HouseCreator {
    HouseType houseType = HouseType.CountryHouse;

    Wall wallNorth;
    Wall wallSouth;
    Wall wallEast;
    Wall wallWest;
    Door door;
    Roof roof;

    public void createHouse() {

        switch (houseType) {
            case TreeHouse:
                wallNorth = new WoodenWall();
                wallSouth = new WoodenWall();
                wallEast = new WoodenWall();
                wallWest = new WoodenWall();

                door = null;
                roof = new WoodenRoof();
                break;

            case CountryHouse:
                wallNorth = new WoodenWall();
                wallSouth = new WoodenWall();
                wallEast = new WoodenWall();
                wallWest = new WoodenWall();

                door = new WoodenDoor();
                roof = new WoodenRoof();
                break;
        }
    }
}

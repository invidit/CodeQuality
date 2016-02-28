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
    private final HouseType  houseType = HouseType.CountryHouse;

    public Wall wallNorth;
    public Wall wallSouth;
    public Wall wallEast;
    public Wall wallWest;
    public Door door;
    public Roof roof;

    public void createHouse() {

        switch (houseType) {
            case TreeHouse:
                wallNorth = new WoodenWall();
                wallSouth = new WoodenWall();
                wallEast = new WoodenWall();
                wallWest = new WoodenWall();

                door = new NoDoor();
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

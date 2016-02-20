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
public class AbstractFactoryExample {
    public static void main(String... args) {

        // change type of house, see enum HouseType for possible types
        HouseFactory factory = new HouseFactoryDecider().createRequiredFactory(HouseType.CountryHouse);

        Door door = factory.createDoor();
        Roof roof = factory.createRoof();
        Wall firstWall = factory.createWall();
        Wall secondWall = factory.createWall();
        Wall thirdWall = factory.createWall();
        Wall fourthWall = factory.createWall();

        System.out.println("House components created:");
        System.out.println("Door: " + door.getClass());
        System.out.println("Roof: " + roof.getClass());
        System.out.println("FirstWall: " + firstWall.getClass());
        System.out.println("SecondWall: " + secondWall.getClass());
        System.out.println("ThirdWall: " + thirdWall.getClass());
        System.out.println("FourthWall: " + fourthWall.getClass());
    }
}

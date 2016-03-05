/*
 * Copyright (c) 2016. InvidIT.de
 */

package de.invidit.design.creational.singleton;

/**
 * @author Torsten Mingers
 * @since 05.03.2016
 */
public class SimpleLogger {

    private static SimpleLogger instance;

    private SimpleLogger() {
    }

    public static SimpleLogger getLogger() {
        if (instance == null) {
            instance = new SimpleLogger();
        }
        return instance;
    }

    public void Log(Object textToLog) {
        System.out.println(textToLog);
    }
}

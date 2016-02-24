/*
 * Copyright (c) 2016. InvidIT.de
 */

package de.invidit.design.creational.singleton;

/**
 * @author Michael Weber
 * @since 24.02.2016
 */
public class Logger {

    private static Logger instance;

    private Logger() {
    }

    public static Logger getLogger() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void Log(Object textToLog) {
        System.out.println(textToLog);
    }
}

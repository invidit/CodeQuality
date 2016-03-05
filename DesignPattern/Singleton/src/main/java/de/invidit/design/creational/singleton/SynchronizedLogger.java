/*
 * Copyright (c) 2016. InvidIT.de
 */

package de.invidit.design.creational.singleton;

/**
 * @author Michael Weber
 * @since 24.02.2016
 */
public class SynchronizedLogger {

    private static SynchronizedLogger instance;

    private SynchronizedLogger() {
    }

    public synchronized static SynchronizedLogger getLogger() {
        if (instance == null) {
            instance = new SynchronizedLogger();
        }
        return instance;
    }

    public void Log(Object textToLog) {
        System.out.println(textToLog);
    }
}

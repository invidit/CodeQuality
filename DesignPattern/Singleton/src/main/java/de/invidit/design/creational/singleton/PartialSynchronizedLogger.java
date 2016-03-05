/*
 * Copyright (c) 2016. InvidIT.de
 */

package de.invidit.design.creational.singleton;

/**
 * @author Michael Weber
 * @since 24.02.2016
 */
public class PartialSynchronizedLogger {

    private volatile static PartialSynchronizedLogger instance;

    private PartialSynchronizedLogger() {
    }

    public static PartialSynchronizedLogger getLogger() {
        if (instance == null) {
            synchronized (PartialSynchronizedLogger.class) {
                if (instance == null) {
                    instance = new PartialSynchronizedLogger();
                }
            }
        }
        return instance;
    }

    public void Log(Object textToLog) {
        System.out.println(textToLog);
    }
}

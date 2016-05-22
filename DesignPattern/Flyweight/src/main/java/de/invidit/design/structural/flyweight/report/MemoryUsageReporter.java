package de.invidit.design.structural.flyweight.report;

import java.util.function.Consumer;

/**
 * @author Michael Weber
 * @since 21.05.2016
 */
public class MemoryUsageReporter {
    private static final long MEGABYTE = 1024L * 1024L;

    public void ReportTo(Consumer<String> reportTo) {
        Runtime runtime = Runtime.getRuntime();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        reportTo.accept("Used memory: " + bytesToMegabytes(memory) + " MB.");
    }

    private long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }
}
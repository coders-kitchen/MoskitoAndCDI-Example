package com.coderskitchen.macdi.process;

/**
 * This class creates new ProcessId
 */
public class ProcessBoundary {
    public String createNewProcessId() {
        long timeInMs = System.currentTimeMillis();
        return "ID" + timeInMs;
    }
}

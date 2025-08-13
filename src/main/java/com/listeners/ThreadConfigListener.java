package com.listeners;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;
 
import java.util.List;
 
public class ThreadConfigListener implements IAlterSuiteListener {
 
    @Override
    public void alter(List<XmlSuite> suites) {
        int threadCount = Integer.parseInt(System.getProperty("threads"));
        String parallelMode = System.getProperty("parallel").toUpperCase();
 
        for (XmlSuite suite : suites) {
            try {
                suite.setParallel(XmlSuite.ParallelMode.valueOf(parallelMode));
            } catch (IllegalArgumentException e) {
                System.err.println("[ThreadConfigListener] Invalid parallel mode '" + parallelMode + "', defaulting to TESTS.");
                suite.setParallel(XmlSuite.ParallelMode.TESTS);
            }
            suite.setThreadCount(threadCount);
            System.out.println("[ThreadConfigListener] Parallel Mode: " + suite.getParallel()
                    + " | Thread Count: " + threadCount);
        }
    }
}
package ru.job4j.io;

import org.apache.log4j.Logger;

import java.util.logging.LogManager;

public class UsageLog4j {

    private static final Logger LOG = Logger.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}

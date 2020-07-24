package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        char sign = '$';
        byte size = 8;
        short salary = 150;
        int age = 29;
        long number = 123454684L;
        float height = 1.84f;
        double weight = 101.4;
        boolean speakEnglish = true;

        LOG.debug("Char: {}, byte: {}, short: {}, int: {}, long: {}, float: {}, double: {}, boolean: {}",
                sign, size, salary, age, number, height, weight, speakEnglish);
    }
}

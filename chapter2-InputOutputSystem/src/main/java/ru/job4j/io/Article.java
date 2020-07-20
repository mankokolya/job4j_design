package ru.job4j.io;

import java.util.Arrays;

public class Article {
    public static boolean generateBy(String origin, String line, String regex) {
        String[] lineSeparated = line.split(regex);
        return Arrays.stream(lineSeparated)
                .allMatch(origin::contains);
    }
}

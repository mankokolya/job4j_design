package ru.job4j.io;

import java.io.File;
import java.nio.file.Files;
import java.util.Objects;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size: %s", file.getTotalSpace()));
        for (File subFile : Objects.requireNonNull(file.listFiles())) {
            if (!subFile.isDirectory()) {
                System.out.println("Name: " + subFile.getName() + "; size in bytes: " + subFile.length());
            }
        }
    }
}

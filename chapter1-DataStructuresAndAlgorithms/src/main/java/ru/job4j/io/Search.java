package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Search {
    public static void main(String[] args) {
        Path start = Paths.get(".");
        try {
            search(start, "java").forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}

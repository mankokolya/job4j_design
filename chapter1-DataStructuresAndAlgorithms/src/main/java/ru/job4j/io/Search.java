package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Search {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Use java -jar dir.jar ROOT_FOLDER");
        }
        Path start = Paths.get(args[0]);
        try {
            search(start, args[1]).forEach(System.out::println);
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

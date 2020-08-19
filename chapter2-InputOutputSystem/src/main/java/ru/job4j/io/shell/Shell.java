package ru.job4j.io.shell;

import java.util.*;
import java.io.File;
import java.nio.file.Paths;

public class Shell {
    private final List<String> pathBuilder = new LinkedList<>();

    public void cd(String path) {
        this.pathBuilder.add(path);
    }

    public String pwd() {
        String path = String.join(File.separator, pathBuilder);
        if (!path.startsWith(File.separator)) {
            path = File.separator + path;
        }
        return Paths.get(path).normalize().toString();
    }
}
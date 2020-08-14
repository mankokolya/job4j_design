package ru.job4j.io.shell;


import java.io.File;
import java.nio.file.Paths;
import java.util.StringJoiner;

public class Shell {
    private final StringJoiner pathBuilder = new StringJoiner(File.separator);

    public void cd(String path) {
        this.pathBuilder.add(path);
    }

    public String pwd() {
        String path = pathBuilder.toString();
        if (!path.startsWith(File.separator)) {
            path = File.separator + path;
        }
        return Paths.get(path).normalize().toString();
    }
}
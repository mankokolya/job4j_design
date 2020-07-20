package ru.job4j.io;

import java.io.*;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        for (Path file : sources) {
            packSingleFile(file.toFile(), target);
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        if (argZip.valid()) {
            Zip zip = new Zip();
            Path root = Paths.get(argZip.directory());
            SearchFiles searchFiles = new SearchFiles(path -> !path.toFile().getName().endsWith(".class"));
            Files.walkFileTree(root, searchFiles);
            List<Path> files = searchFiles.getPaths();
            File target = new File(argZip.output());
            zip.packFiles(files, target);
        }
    }
}

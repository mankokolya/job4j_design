package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zipFile(path.toFile(), zip);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void zipFile(File fileToZip, ZipOutputStream zipOutput) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            File[] children = fileToZip.listFiles();
            for (File childFile : Objects.requireNonNull(children)) {
                packSingleFile(childFile, zipOutput);
            }
            return;
        }
        packSingleFile(fileToZip, zipOutput);
    }

    public void packSingleFile(File childFile, ZipOutputStream zipOutput) throws IOException {
        zipOutput.putNextEntry(new ZipEntry(childFile.getPath()));
        try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(childFile))) {
            zipOutput.write(out.readAllBytes());
        }
    }

    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        if (argZip.valid()) {
            Zip zip = new Zip();
            Path root = Paths.get(argZip.directory());
            SearchFiles searchFiles = new SearchFiles(path -> !path.toFile().getName().endsWith(argZip.exclude()));
            Files.walkFileTree(root, searchFiles);
            List<Path> files = searchFiles.getPaths();
            File target = new File(argZip.output());
            zip.packFiles(files, target);
        }
    }
}

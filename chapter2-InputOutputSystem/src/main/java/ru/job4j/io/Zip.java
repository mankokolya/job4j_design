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
                zipFile(path.toFile(), target.getName(), zip);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void zipFile(File fileToZip, String fileName, ZipOutputStream zipOutput) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOutput.putNextEntry(new ZipEntry(fileName));
            } else {
                zipOutput.putNextEntry(new ZipEntry(fileName + "/"));
            }

            File[] children = fileToZip.listFiles();
            for (File childFile : Objects.requireNonNull(children)) {
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOutput);
            }
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

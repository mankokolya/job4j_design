package ru.job4j.io.filesearcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.SearchFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class FileFinder {
    private static final Logger LOG = LoggerFactory.getLogger(FileFinder.class.getName());

    public static void main(String[] args) {
        try {
            AnalyseArgs analyseArgs = new AnalyseArgs(args);
            if (analyseArgs.valid()) {
                Path root = Path.of(analyseArgs.directory());
                Predicate<Path> searchPredicate = createPredicate(analyseArgs.getSearchMode(), analyseArgs.searchingCriteria());
                SearchFiles searchFiles = new SearchFiles(searchPredicate);
                Files.walkFileTree(root, searchFiles);
                List<Path> files = searchFiles.getPaths();
                writeToFile(files, new File(analyseArgs.output()));
            }
        } catch (Exception e) {
            LOG.error(e.toString());
        }
    }

    private static void writeToFile(List<Path> files, File target) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            for (Path path : files) {
                writer.write(path.toString());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Predicate<Path> createPredicate(String searchMode, String criteria) {
        Predicate<Path> rls = null;
        switch (searchMode) {
            case "-m" -> {
                Pattern mask = Pattern.compile(criteria.replace(".", "[.]")
                        .replace("*", ".*").replace("?", "."));
                rls = path -> mask.matcher(path.toFile().getName()).matches();
            }
            case "-f" -> rls = path -> path.toFile().getName().equals(criteria);
            case "-r" -> {
                Pattern pattern = Pattern.compile(criteria);
                rls = path -> pattern.matcher(path.toFile().getName()).matches();
            }
        }
        return rls;
    }
}

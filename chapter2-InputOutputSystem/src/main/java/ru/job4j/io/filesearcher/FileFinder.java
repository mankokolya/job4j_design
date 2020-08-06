package ru.job4j.io.filesearcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.SearchFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class FileFinder {
    private static final Logger LOG = LoggerFactory.getLogger(FileFinder.class.getName());

    private static Map<String, BiFunction<Path, String, Boolean>> map = Map.of(
            "-m", (path, criteria) -> {
                Pattern pattern = Pattern.compile(criteria
                        .replace(".", "[.]")
                        .replace("*", ".*")
                        .replace("?", ".")
                );
                return pattern.matcher(path.toFile().getName()).matches();
            },
            "-f", (path, criteria) -> path.toFile().getName().equals(criteria),
            "-r", (path, criteria) -> Pattern.compile(criteria).matcher(path.toFile().getName()).matches()
    );

    public static void main(String[] args) {
        try {
            AnalyseArgs analyseArgs = new AnalyseArgs(args);
            if (analyseArgs.valid()) {
                List<Path> files = getPaths(analyseArgs, Path.of(analyseArgs.directory()));
                writeToFile(files, new File(analyseArgs.output()));
            }
        } catch (Exception e) {
            LOG.error(e.toString());
        }
    }

    private static List<Path> getPaths(AnalyseArgs analyseArgs, Path root) throws IOException {
        Predicate<Path> searchPredicate = createPredicate(analyseArgs.getSearchMode(), analyseArgs.searchingCriteria());
        SearchFiles searchFiles = new SearchFiles(searchPredicate);
        Files.walkFileTree(root, searchFiles);
        return searchFiles.getPaths();
    }

    private static void writeToFile(List<Path> files, File target) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            for (Path path : files) {
                writer.write(path.toString());
                writer.newLine();
            }
        } catch (Exception e) {
            LOG.error(e.toString());
        }
    }

    private static Predicate<Path> createPredicate(String searchMode, String criteria) {
        BiFunction<Path, String, Boolean> function = map.get(searchMode);
        Predicate<Path> pathPredicate = path -> true;
        if (function != null) {
            pathPredicate = path -> function.apply(path, criteria);
        }
        return pathPredicate;
    }
}

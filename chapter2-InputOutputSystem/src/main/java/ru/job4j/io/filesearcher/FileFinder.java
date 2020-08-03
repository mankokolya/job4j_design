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
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class FileFinder {
    private static final Logger LOG = LoggerFactory.getLogger(FileFinder.class.getName());

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
        Map<String, Predicate<Path>> rsl = new HashMap<>();
        rsl.put("-m", path -> Pattern.compile(criteria.replace(".", "[.]")
                .replace("*", ".*").replace("?", ".")).matcher(path.toFile().getName()).matches());
        rsl.put("-f", path -> path.toFile().getName().equals(criteria));
        rsl.put("-r", path -> Pattern.compile(criteria).matcher(path.toFile().getName()).matches());

        return rsl.get(searchMode);
    }
}

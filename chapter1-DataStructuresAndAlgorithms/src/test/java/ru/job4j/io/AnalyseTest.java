package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.StringJoiner;

import static org.junit.Assert.*;

public class AnalyseTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    private final Analyse analyse = new Analyse();

    @Test
    public void analyse() throws IOException {
        File source = folder.newFile("server.txt");
        File target = folder.newFile("unavailable.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01" + System.lineSeparator()
                    + "500 10:57:01" + System.lineSeparator()
                    + "400 10:58:01" + System.lineSeparator()
                    + "200 10:59:01" + System.lineSeparator()
                    + "500 11:01:02" + System.lineSeparator()
                    + "200 11:02:02");
        }
        analyse.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringJoiner dataFromFile = new StringJoiner(System.lineSeparator());
        try (BufferedReader in = new BufferedReader(new FileReader(target.getAbsoluteFile()))) {
            in.lines().forEach(dataFromFile::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String expected = "10:57:01 - 10:59:01"
                + System.lineSeparator() + "11:01:02 - 11:02:02";
        assertEquals(expected, dataFromFile.toString());
    }
}
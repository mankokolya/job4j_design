package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringJoiner;

import static org.junit.Assert.*;

public class AnalyseTest {
    private final Analyse analyse = new Analyse();

    @Test
    public void analyse() {
        analyse.unavailable("./data/server.txt", "./data/unavailable.csv");
        StringJoiner dataFromFile = new StringJoiner(System.lineSeparator());
        try (BufferedReader in = new BufferedReader(new FileReader("./data/unavailable.csv"))) {
            in.lines().forEach(dataFromFile::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String expected = "10:57:01 - 10:59:01"
                + System.lineSeparator() + "11:01:02 - 11:02:02";
        assertEquals(expected, dataFromFile.toString());
    }
}
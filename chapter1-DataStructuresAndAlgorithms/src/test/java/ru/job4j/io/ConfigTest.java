package ru.job4j.io;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigTest {
    @Test
    public void whenSourceWithoutComment() {
        String path = "./data/data_without_comments.properties";
        Config config = new Config(path);
        config.load();
        assertEquals("Manko Kolya", config.value("nick"));
    }

    @Test
    public void whenSourceWithCommentsAndEmptyLines() {
        String path = "./data/data_with_comments.properties";
        Config config = new Config(path);
        config.load();
        assertEquals("Bill Golden", config.value("bill"));
    }

}
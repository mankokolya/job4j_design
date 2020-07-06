package ru.job4j.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void whenAddDuplicateThenTrue() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("Hello");
        simpleSet.add("Bye");
        assertTrue(simpleSet.checkDuplicate("Hello"));
    }

}
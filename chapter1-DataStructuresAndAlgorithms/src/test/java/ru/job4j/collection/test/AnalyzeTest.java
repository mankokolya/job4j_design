package ru.job4j.collection.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AnalyzeTest {
    private final Analyze newAnalyze = new Analyze();
    private Analyze.User nick = new Analyze.User(125, "Nick");
    private Analyze.User bill = new Analyze.User(124, "Bill");
    private Analyze.User john = new Analyze.User(123, "John");
    private Analyze.User nick2 = new Analyze.User(125, "Nick");
    private Analyze.User bill2 = new Analyze.User(124, "Bill");
    private final List<Analyze.User> original = new ArrayList<>();
    private List<Analyze.User> modernized = new ArrayList<>();

    @Test
    public void whenAdd1NewThenAdded1() {
        original.add(nick);
        original.add(bill);
        modernized.add(nick2);
        modernized.add(bill2);
        modernized.add(john);
        assertEquals(1, newAnalyze.diff(original, modernized).added);
    }

    @Test
    public void whenAdd2AndDelete1ThenDeleted1() {
        original.add(nick);
        original.add(bill);
        modernized.add(nick2);
        modernized.add(bill2);
        modernized.remove(bill2);
        assertEquals(1, newAnalyze.diff(original, modernized).deleted);
    }

    @Test
    public void whenChange1ThenChanged1() {
        original.add(nick);
        original.add(bill);
        modernized.add(nick2);
        modernized.add(bill2);
        bill2.name = "golden";
        assertEquals(1, newAnalyze.diff(original, modernized).changed);
    }
}
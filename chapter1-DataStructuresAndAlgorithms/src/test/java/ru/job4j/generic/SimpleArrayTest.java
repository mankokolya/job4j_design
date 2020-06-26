package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    private SimpleArray<String> simpleArray = new SimpleArray<>(10);

    @Before
    public void initialize() {
        simpleArray.add("java");
        simpleArray.add("maven");
    }

    @Test
    public void add() {
        assertThat(simpleArray.get(0), is("java"));
    }

    @Test
    public void set() {
        simpleArray.set(1, "John");
        assertThat(simpleArray.get(1), is("John"));
    }

    @Test
    public void setWhenIndexOutOfBound() throws Exception {
        simpleArray.set(2, "Bill");
    }

    @Test
    public void remove() {
        simpleArray.add("Bill");
        simpleArray.remove(1);
        assertThat(simpleArray.get(1), is("Bill"));
    }

    @Test
    public void removeWhenIndexOutOfBound() throws Exception {
        simpleArray.remove(5);
    }

    @Test
    public void getWhenIndexOutOfBound() throws Exception {
        simpleArray.get(5);
    }
}
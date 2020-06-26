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

    @Test(expected = IndexOutOfBoundsException.class)
    public void setWhenIndexOutOfBound() {
        simpleArray.set(2, "Bill");
    }

    @Test
    public void remove() {
        simpleArray.add("Bill");
        simpleArray.remove(1);
        assertThat(simpleArray.get(1), is("Bill"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeWhenIndexOutOfBound() {
        simpleArray.remove(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getWhenIndexOutOfBound() {
        simpleArray.get(5);
    }
}
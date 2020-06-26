package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleListTest {
    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        SimpleList<String> simple = new SimpleList<>(4);
        simple.add("test");
        String result = simple.get(0);
        assertThat(result, is("test"));
    }

}
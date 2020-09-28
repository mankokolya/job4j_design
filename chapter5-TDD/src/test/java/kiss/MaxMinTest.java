package kiss;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class MaxMinTest {
    private final List<Integer> ints = List.of(12, 15, 4, 6);
    private final List<String> strings = List.of("name", "profession", "hobby", "i");
    private final MaxMin maxMin = new MaxMin();

    @Test
    public void max() {
        assertThat(15, is(maxMin.max(ints, Integer::compare)));
    }

    @Test
    public void maxStringLength() {
        assertThat("profession", is(maxMin.max(strings, Comparator.comparingInt(String::length))));
    }

    @Test
    public void min() {
        assertThat(4, is(maxMin.min(ints, (int1, int2) -> Integer.compare(int2, int1))));
    }

    @Test
    public void minStringLength() {
        assertThat("i", is(maxMin.min(strings, (st1, st2) -> Integer.compare(st2.length(), st1.length()))));
    }
}
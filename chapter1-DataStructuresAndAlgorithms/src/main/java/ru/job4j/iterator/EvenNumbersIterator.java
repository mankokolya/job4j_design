package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class EvenNumbersIterator implements Iterator<Integer> {

    private final int[] data;
    private int index = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (index < data.length - 1) {
            while (index < data.length && !checkEven()) {
                index++;
            }
        }
        return index < data.length && checkEven();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }

    private boolean checkEven() {
        return data[index] % 2 == 0;
    }
}

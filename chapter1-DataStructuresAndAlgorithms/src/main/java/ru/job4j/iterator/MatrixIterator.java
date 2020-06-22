package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIterator(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (row != data.length - 1) {
            while (row < data.length && data[row].length == 0) {
                row++;
            }
        }
        return column < data[row].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Integer result = data[row][column++];
        if (column == data[row].length) {
            column = 0;
            row++;
        }
        return result;
    }
}

package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> iterator;

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    @Override
    public T next() {
//        if (!data.hasNext()) {
//            throw new NoSuchElementException();
//        }
        if (iterator == null || !iterator.hasNext()) {
            iterator = data.next();
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return data.hasNext() || iterator.hasNext();
    }

    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();

        FlatMap<Integer> flatMap = new FlatMap<>(data);
        while (flatMap.hasNext()) {
            System.out.println(flatMap.next());
        }
    }
}

package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container;
    private int size = 0;
    private int modCount = 0;

    public SimpleArray(int size) {
        this.container = new Object[size];
    }

    public SimpleArray() {
        this.container = new Object[10];
    }

    public T get(int index) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    public void add(T model) {
        if (modCount >= container.length * 0.8) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[size++] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int position = 0;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                checkForModification(expectedModCount);
                return position < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[position++];
            }
        };
    }

    final void checkForModification(int expectedModCount) {
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
}

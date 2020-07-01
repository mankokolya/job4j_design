package ru.job4j.generic;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[index++] = model;
    }

    public void set(int position, T model) throws IndexOutOfBoundsException {
        Objects.checkIndex(position, index);
        this.objects[position] = model;
    }

    public void remove(int position) throws IndexOutOfBoundsException {
        Objects.checkIndex(position, index);
        this.objects[position] = null;
        System.arraycopy(objects, position + 1, objects, position, index - position);
        index--;
    }


    public T get(int position) throws IndexOutOfBoundsException {
        T result = (T) new Object();
        if (Objects.checkIndex(position, index) == position) {
            result = (T) this.objects[position];
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[position++];
            }
        };
    }
}

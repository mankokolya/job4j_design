package ru.job4j.generic;

import java.util.*;
import java.util.function.Consumer;

public class SimpleArray<T> implements Iterable {
    Object[] objects;
    int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[index++] = model;
    }

    public void set(int position, T model) throws IndexOutOfBoundsException {
        if (Objects.checkIndex(position, index) == position) {
            this.objects[position] = model;
        }
    }

    public void remove(int position) throws IndexOutOfBoundsException {
        if (Objects.checkIndex(position, index) == position) {
            this.objects[position] = null;
            System.arraycopy(objects, position + 1, objects, position, index - position);
            index--;
        }
    }


    public T get(int position) throws IndexOutOfBoundsException {
        T result = (T) new Object();
        if (Objects.checkIndex(position, index) == position) {
            result = (T) this.objects[position];
        }
        return result;
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return objects.length > position;
            }

            @Override
            public Object next() {
                return objects[position++];
            }
        };
    }
}

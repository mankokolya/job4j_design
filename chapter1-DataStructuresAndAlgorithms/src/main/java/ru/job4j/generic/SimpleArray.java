package ru.job4j.generic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> {
    Object[] objects;
    int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[index++] = model;
    }

    public void set(int position, T model) {
        try {
            if (Objects.checkIndex(position, index) == position) {
                this.objects[position] = model;
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void remove(int position) {
        try {
            if (Objects.checkIndex(position, index) == position) {
                this.objects[position] = null;
                int nextValue = position + 1;
                while (this.objects[nextValue] != null) {
                    this.objects[position++] = this.objects[nextValue];
                    this.objects[nextValue++] = null;
                }
                index--;
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public T get(int position) {
        T result = (T) new Object();
        try {
            if (Objects.checkIndex(position, index) == position) {
                result = (T) this.objects[position];
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
}

package ru.job4j.generic;

public class SimpleList<E> {

    Object[] objects;
    int index = 0;
    public SimpleList(int size) {
        this.objects = new Object[size];
    }

    public void add(E value) {
        this.objects[index++] = value;
    }

    public E get(int position) {
        return (E) this.objects[position];
    }

}

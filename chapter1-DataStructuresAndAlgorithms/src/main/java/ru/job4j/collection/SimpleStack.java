package ru.job4j.collection;

public class SimpleStack<T> {
    private MyLinkedList<T> stack = new MyLinkedList<>();

    public T pop() {
        return stack.deleteLast();
    }

    public void push(T value) {
        stack.add(value);
    }

    public boolean isEmpty() {
        return stack.size == 0;
    }
}

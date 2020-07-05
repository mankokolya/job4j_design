package ru.job4j.collection;

import com.sun.jdi.Value;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();


    public T poll() {
        return getFirstQueueValue();
    }

    public void push(T value) {
        in.push(value);
    }

    public T getFirstQueueValue() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        T value = out.pop();
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
        return value;
    }
}

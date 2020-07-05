package ru.job4j.collection;

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
        while (out.isEmpty() && !in.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
}

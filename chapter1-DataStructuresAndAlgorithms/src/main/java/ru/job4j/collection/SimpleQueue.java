package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();


    public T poll() {
        reverseStack(in, out);
        T firstValue = out.pop();
        reverseStack(out, in);
        return firstValue;
    }

    public void push(T value) {
        in.push(value);
    }

    public void reverseStack(SimpleStack<T> input, SimpleStack<T> output) {
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
    }
}

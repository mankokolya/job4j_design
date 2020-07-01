package ru.job4j.collection;

public class Node<T> {
    private T model;
    private Node<T> next;

    public Node() {
        this.model = null;
        next = null;
    }

    public Node(T model, Node<T> next) {
        this.model = model;
        this.next = next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setData(T model) {
        this.model = model;
    }

    public T getData() {
        return this.model;
    }
}

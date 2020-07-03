package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int modCount = 0;
    public int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T model) {
        Node<T> tempVal = new Node(model, null);
        size++;
        modCount++;
        if (head == null) {
            head = tempVal;
            tail = head;
        } else {
            tail.setNext(tempVal);
            tail = tempVal;
        }
    }

    public T get(int index) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, size);
        Node<T> temp = head;
        int count = 0;
        while (count != index) {
            temp = temp.getNext();
            count++;
        }
        return temp.getData();
    }

    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> temp = head.getNext();
        head = null;
        head = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            final int expectedModCount = modCount;
            Node<T> tempVal = head;

            @Override
            public boolean hasNext() {
                checkForModification(expectedModCount);
                return tempVal != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<T> valToReturn = tempVal;
                tempVal = tempVal.getNext();
                return valToReturn.getData();
            }
        };


    }

    final void checkForModification(int expectedModCount) {
        if (size != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
}

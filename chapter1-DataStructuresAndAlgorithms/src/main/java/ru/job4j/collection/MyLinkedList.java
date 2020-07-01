package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    public int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T model) {
        Node<T> tempVal = new Node(model, null);
        size++;
        if (head == null) {
            head = tempVal;
            tail = head;
        } else {
            tail.setNext(tempVal);
            tail = tempVal;
        }
    }

    public T get(int index) {
        if (Objects.checkIndex(index, size) == index) {
            Node<T> temp = head;
            int count = 0;
            while (count != index) {
                temp = temp.getNext();
                count++;
            }
            return temp.getData();
        }
        throw new IndexOutOfBoundsException();
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            final int expectedModCount = size;
            Node<T> tempVal = head;

            @Override
            public boolean hasNext() {
                checkForModification(expectedModCount);
                return tail != head || tail != null;
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

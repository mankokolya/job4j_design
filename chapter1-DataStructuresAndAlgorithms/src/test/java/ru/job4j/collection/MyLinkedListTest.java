package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MyLinkedListTest {

    @Test
    public void addAndGet() {
        MyLinkedList<String> myLink = new MyLinkedList<>();
        myLink.add("Hello");
        myLink.add("Java");
        String result = myLink.get(1);
        assertThat(result, is("Java"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetIndexOutOfBound() {
        MyLinkedList<String> myLink = new MyLinkedList<>();
        myLink.add("Hello");
        myLink.add("Java");
        String result = myLink.get(2);

    }

    @Test
    public void checkIterator() {
        MyLinkedList<String> myLink = new MyLinkedList<>();
        myLink.add("Hello");
        String result = myLink.iterator().next();
        assertThat(result, is("Hello"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyIterator() {
        MyLinkedList<String> myLink = new MyLinkedList<>();
        String result = myLink.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenConcurrentModificationIterator() {
        MyLinkedList<String> myLink = new MyLinkedList<>();
        myLink.add("Hello");
        Iterator<String> it = myLink.iterator();
        myLink.add("Java");
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirst() {
        MyLinkedList<Integer> linked = new MyLinkedList<>();
        linked.add(1);
        linked.deleteFirst();
        linked.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked() {
        MyLinkedList<Integer> linked = new MyLinkedList<>();
        linked.deleteFirst();
    }

    @Test
    public void whenMultiDelete() {
        MyLinkedList<Integer> linked = new MyLinkedList<>();
        linked.add(1);
        linked.add(2);
        linked.deleteFirst();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
    }

    @Test
    public void deleteLast() {
        MyLinkedList<String> myLink = new MyLinkedList<>();
        myLink.add("Hello");
        myLink.add("Java");
        myLink.deleteLast();
        assertThat(myLink.size, is(1));
    }

}
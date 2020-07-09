package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MyHashMapTest {
    private MyHashMap<String, User> map = new MyHashMap<>();
    private User nick = new User("Nick", 0, new GregorianCalendar());
    private User bill = new User("Bill", 1, new GregorianCalendar());

    @Test
    public void insert() {
        map.insert(nick.getName(), nick);
        assertFalse(map.insert(nick.getName(), nick));
    }

    @Test
    public void iterator() {
        map.insert(nick.getName(), nick);
        map.insert(bill.getName(), bill);
        Iterator<String> user = map.iterator();
        user.next();
        assertEquals(bill.getName(), user.next());
    }

    @Test
    public void insertThenGet() {
        map.insert(nick.getName(), nick);
        assertEquals(nick, map.get("Nick"));
    }

    @Test (expected = NoSuchElementException.class)
    public void deleteThenGet() {
        map.insert(nick.getName(), nick);
        map.delete("Nick");
        assertNull(map.get("Nick"));
    }

    @Test
    public void insertThenDelete() {
        map.insert(nick.getName(), nick);
        assertTrue(map.delete("Nick"));
    }


    @Test
    public void whenAddThenIt() {
        map.insert(nick.getName(), nick);
        String rsl = map.iterator().next();
        assertThat(rsl, is("Nick"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        MyHashMap<String, User> map = new MyHashMap<>();
        map.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        map.insert(nick.getName(), nick);
        Iterator<String> it = map.iterator();
        map.insert(bill.getName(), bill);
        it.next();
    }

}
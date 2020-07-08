package ru.job4j.collection;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class MyHashMapTest {
    private MyHashMap<String, User> map = new MyHashMap<>();
    private User nick = new User("Nick", 0, new GregorianCalendar());
    private User bill = new User("Bill", 1, new GregorianCalendar());

    @Test
    public void insert() {
        map.insert(nick.getName(), nick);
        map.insert(bill.getName(), bill);
//        assertFalse(map.insert(nick.getName(), nick));
        assertEquals(2, map.size());

    }

}
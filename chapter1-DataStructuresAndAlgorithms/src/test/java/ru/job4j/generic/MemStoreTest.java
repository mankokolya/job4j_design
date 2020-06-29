package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MemStoreTest {
    private final Store<User> userStore = new MemStore<>();
    private final User nick = new User("Nick");
    private final User john = new User("John");
    private final User ben = new User("Ben");

    @Test
    public void add() {
        userStore.add(nick);
        assertThat(userStore.findById("Nick"), is(nick));
    }

    @Test
    public void replace() {
        userStore.add(john);
        assertTrue(userStore.replace(john.getId(), ben));

    }

    @Test
    public void delete() {
        userStore.add(nick);
        assertTrue(userStore.delete(nick.getId()));
    }

}
package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import static java.util.Objects.hash;

public class MyHashMap<K, V> implements Iterable<K> {
    private Entry[] entriesContainer;
    private int capacity;
    private int entriesInContainer = 0;
    private int modCount = 0;
    private double loadFactor = 0.8;

    MyHashMap() {
        this.capacity = 16;
        this.entriesContainer = new Entry[capacity];
    }


    public boolean insert(K key, V value) {
        boolean result = false;
        Entry<K, V> newNode = new Entry<>(key, value);
        int index = indexOf(key);
        if (entriesInContainer >= entriesContainer.length * loadFactor) {
            entriesContainer = Arrays.copyOf(entriesContainer, entriesContainer.length * 2);
        }
        if (!checkKeyDuplicate(key)) {
            entriesContainer[index] = newNode;
            modCount++;
            entriesInContainer++;
            result = true;
        }
        return result;
    }

    private int indexOf(K key) {
        return key.hashCode() & (this.capacity - 1);
    }

    private boolean checkKeyDuplicate(K key) {
        return Arrays.stream(entriesContainer)
                .filter(Objects::nonNull)
                .anyMatch(node -> Objects.equals(node.key, key));
    }


    private static class Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key);
        }

        @Override
        public int hashCode() {
            return hash(key);
        }
    }

    public int size() {
        return this.entriesInContainer;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}

package ru.job4j.collection;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    MyHashMap(int capacity) {
        this.capacity = capacity;
        this.entriesContainer = new Entry[this.capacity];
    }

    public boolean insert(K key, V value) {
        boolean result = false;
        Entry<K, V> newNode = new Entry<>(key, value);
        int index = indexOf(key);
        System.out.println(key + " " + index);
        if (entriesInContainer >= entriesContainer.length * loadFactor) {
            capacity = entriesContainer.length * 2;
            shiftEntriesIndex();
        }
        if (entriesContainer[index] == null) {
            entriesContainer[index] = newNode;
            modCount++;
            entriesInContainer++;
            result = true;
        }
        return result;
    }

    private Entry[] shiftEntriesIndex() {
        Entry[] temp = new Entry[capacity];
        for (Entry entry : entriesContainer) {
            if (entry != null) {
                temp[indexOf((K) entry.key)] = entry;
            }
        }
        return temp;
    }

    public V get(K key) {
        Entry valueToReturn = entriesContainer[indexOf(key)];

        return valueToReturn == null ? null : (V) valueToReturn.value;
    }

    public boolean delete(K key) {
        boolean result = false;
        int index = indexOf(key);

        if (entriesContainer[index] != null && Objects.equals(entriesContainer[index].key, key)) {
            entriesContainer[index] = null;
            modCount++;
            entriesInContainer--;
            result = true;
        }
        return result;
    }

    private int indexOf(K key) {
        return key.hashCode() & (this.capacity - 1);
    }


    private static class Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
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
        return new Iterator<>() {
            private int position = 0;
            private int countEntries = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                checkForModification(expectedModCount);
                return countEntries < entriesInContainer;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                countEntries++;
                return findNextValue();
            }

            private K findNextValue() {
                K value = null;
                for (int i = position; i < entriesContainer.length; i++) {
                    if (entriesContainer[i] != null) {
                        value = (K) entriesContainer[i].key;
                        position = i + 1;
                        break;
                    }
                }
                return value;
            }
        };
    }

    final void checkForModification(int expectedModCount) {
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
}

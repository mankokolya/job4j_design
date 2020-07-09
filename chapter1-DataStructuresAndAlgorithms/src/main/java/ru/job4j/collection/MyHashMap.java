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
        if (entriesInContainer >= entriesContainer.length * loadFactor) {
            capacity = entriesContainer.length * 2;
            entriesContainer = Arrays.copyOf(entriesContainer, capacity);
        }
        if (!checkKeyDuplicate(key)) {
            entriesContainer[index] = newNode;
            modCount++;
            entriesInContainer++;
            result = true;
        }
        return result;
    }

    public V get(K key) throws NoSuchElementException {
        if (entriesContainer[indexOf(key)] == null) {
            throw new NoSuchElementException();
        }
        return (V) entriesContainer[indexOf(key)].value;
    }

    public boolean delete(K key) {
        boolean result = false;
        int index = indexOf(key);
        if(entriesContainer[index] != null) {
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
            private int expectedModCount = modCount;
            final Entry[] noNullEntries = Arrays.stream(entriesContainer)
                    .filter(Objects::nonNull)
                    .toArray(Entry[]::new);

            @Override
            public boolean hasNext() {
                checkForModification(expectedModCount);
                return position < noNullEntries.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (K) noNullEntries[position++].key;
            }

            private void skipNull() {
                while(entriesContainer[position] == null && position < capacity) {
                    position++;
                }
            }
        };
    }

    final void checkForModification(int expectedModCount) {
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
}

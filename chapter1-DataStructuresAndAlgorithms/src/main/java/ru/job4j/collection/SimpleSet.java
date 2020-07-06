package ru.job4j.collection;

public class SimpleSet<T> {
    private final SimpleArray<T> setContainer;

    public SimpleSet() {
        setContainer = new SimpleArray<>();
    }
    public SimpleSet(int size) {
        setContainer = new SimpleArray<>(size);
    }

    public boolean checkDuplicate(T value) {
        boolean result = false;
        for (T t : setContainer) {
            if (t.equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void add(T value) {
        if (!checkDuplicate(value)) {
            setContainer.add(value);
        }
    }
}

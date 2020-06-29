package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            mem.set(index, model);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            mem.remove(index);
        }
        return result;
    }

    @Override
    public T findById(String id) {
        int index = indexOf(id);
        return  index != -1 ? mem.get(index) : null;
    }

    private int indexOf(String id) {
        int caseNotFound = -1;
        int index = 0;
        for (T t : mem) {
            if (t.getId().equals(id)) {
                return index;
            }
            index++;
        }
        return caseNotFound;
    }
}

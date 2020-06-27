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
        boolean result = false;
        Optional<T> toReplace = findById(id);
        if (toReplace.isPresent()) {
            int index = mem.indexOf(toReplace.get());
            mem.set(index, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        Optional<T> toDelete = findById(id);
        if (toDelete.isPresent()) {
            mem.remove(toDelete.get());
            result = true;
        }
        return result;
    }

    @Override
    public Optional<T> findById(String id) {
        return mem.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }
}

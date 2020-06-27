package ru.job4j.generic;

import java.util.Optional;

public interface Store<T extends Base> {
    void add(T model);
    boolean replace(String ig, T model);
    boolean delete(String id);
    Optional<T> findById(String id);
}

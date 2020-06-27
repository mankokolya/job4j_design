package ru.job4j.generic;

import java.util.Optional;

public class RoleStore implements Store<Role> {
    private final Store<Role> roleStore = new MemStore<>();

    @Override
    public void add(Role model) {
        roleStore.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return roleStore.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return roleStore.delete(id);
    }

    @Override
    public Optional<Role> findById(String id) {
        return roleStore.findById(id);
    }
}

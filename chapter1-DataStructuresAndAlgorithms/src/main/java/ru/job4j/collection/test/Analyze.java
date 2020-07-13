package ru.job4j.collection.test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Analyze {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, String> previousMap = previous.stream().collect(Collectors.toMap(User::getId, User::getName));
        Map<Integer, String> currentMap = current.stream().collect(Collectors.toMap(User::getId, User::getName));
        for (Integer id : previousMap.keySet()) {
            if (!currentMap.containsKey(id)) {
                info.deleted++;
            } else {
                String currentUserName = currentMap.remove(id);
                if (previousMap.get(id).equals(currentUserName)) {
                    info.changed++;
                }
            }
        }
        info.added = currentMap.size();
        return info;
    }

    public static class User implements Comparable<User> {
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        int id;
        String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            return Integer.compare(this.id, o.id);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }

}

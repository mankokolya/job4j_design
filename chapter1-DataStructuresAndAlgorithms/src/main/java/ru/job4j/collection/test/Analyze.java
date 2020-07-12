package ru.job4j.collection.test;

import java.util.*;
import java.util.stream.Collectors;

public class Analyze {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        for (User user : previous) {
            int indexInCurrent = current.indexOf(user);
            if (indexInCurrent == -1) {
                info.deleted++;
            } else {
                User currentUser = current.remove(indexInCurrent);
                if (!user.name.equals(currentUser.name)) {
                    info.changed++;
                }
            }
        }
        info.added = current.size();
        return info;
    }

    public static class User implements Comparable<User> {
        int id;
        String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
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

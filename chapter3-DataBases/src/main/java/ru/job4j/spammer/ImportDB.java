package ru.job4j.spammer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class ImportDB {
    private final Properties config;
    private final String dump;

    public ImportDB(Properties config, String dump) {
        this.config = config;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users;
        try (BufferedReader reader = new BufferedReader(new FileReader(dump))) {
            users = reader.lines()
                    .map(line -> new User(line.split(";")[0], line.split(";")[1]))
                    .collect(Collectors.toList());
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(config.getProperty("jdbc.driver"));
        try (Connection connection = DriverManager.getConnection(
                config.getProperty("jdbc.url"),
                config.getProperty("jdbc.username"),
                config.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement statement = connection.prepareStatement("insert into users(name, email) values (?, ?)")) {
                    statement.setString(1, user.name);
                    statement.setString(2, user.email);
                    statement.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (FileInputStream in = new FileInputStream("./chapter3-DataBases/src/main/resources/app.properties")) {
            config.load(in);
        }
        ImportDB db = new ImportDB(config, "./chapter3-DataBases/src/main/resources/dump.txt");
        db.save(db.load());
    }
}

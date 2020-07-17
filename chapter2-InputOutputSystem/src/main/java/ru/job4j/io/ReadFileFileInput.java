package ru.job4j.io;

import java.io.FileInputStream;
import java.util.Arrays;

public class ReadFileFileInput {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] intValues = text.toString().split(System.lineSeparator());
            Arrays.stream(intValues)
                    .map(Integer::parseInt)
                    .filter(number -> number % 2 == 0)
                    .forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

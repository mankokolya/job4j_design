package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            int number;
            while ((number = in.read()) != -1) {
                if (number % 2 == 0) {
                    System.out.println(number);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

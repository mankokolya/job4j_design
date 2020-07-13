package ru.job4j.io;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadFile {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            List<String> lines = new ArrayList<>();
            in.lines().forEach(lines::add);
            for (String  line: lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

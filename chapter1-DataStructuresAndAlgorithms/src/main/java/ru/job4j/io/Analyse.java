package ru.job4j.io;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.*;
import java.util.stream.Collectors;

public class Analyse {
    public void unavailable(String source, String target) {
        List<String[]> spitedSource = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            in.lines().map(s -> s.split(" ")).forEach(spitedSource::add);

            for (String[] string : spitedSource
            ) {
                System.out.println(Arrays.toString(string));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
//            out.println("15:01:30;15:02:32");
//            out.println("15:10:30;23:12:32");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Analyse analyse = new Analyse();
        analyse.unavailable("server.log", "unavailable.csv");
    }
}
package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class Analyse {
    private Iterator<String[]> spIterator;
    private final List<Integer> workingServer = List.of(200, 300);
    private final List<Integer> unavailableServer = List.of(400, 500);

    public void unavailable(String source, String target) {
        spIterator = readSource(source).iterator();
        writeToFile(target, findServerUnavailable());
    }

    private String findServerUnavailable() {
        StringJoiner unavailableTime = new StringJoiner(System.lineSeparator());

        while (spIterator.hasNext()) {
            String notWorkingTime = findNextType(unavailableServer::contains);
            String workingTime = findNextType(workingServer::contains);
            StringJoiner temp = new StringJoiner(" - ");
            temp.add(notWorkingTime);
            temp.add(workingTime);
            unavailableTime.add(temp.toString());
        }
        return unavailableTime.toString();
    }

    private void writeToFile(String target, String data) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String findNextType(Predicate<Integer> predicate) {
        String time = " ";
        while (spIterator.hasNext()) {
            String[] typeAndTime = spIterator.next();
            int type = Integer.parseInt(typeAndTime[0]);
            if (predicate.test(type)) {
                time = typeAndTime[1];
                break;
            }
        }
        return time;
    }

    private List<String[]> readSource(String source) {
        List<String[]> splitted = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            in.lines()
                    .map(s -> s.split(" "))
                    .forEach(splitted::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return splitted;
    }
}
package ru.job4j.io.consolechat;

import java.util.*;
import java.io.*;
import java.util.Scanner;

public class ConsoleChat {
    private String status = "working";
    private final List<String> sourceText;
    private final File outPut;

    public ConsoleChat(File sourceText, File outPut) {
        this.sourceText = splitText(sourceText);
        this.outPut = outPut;
    }

    private List<String> splitText(File sourceText) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(sourceText))) {
            in.lines().map(line -> line.split(" "))
                    .flatMap(Arrays::stream)
                    .forEach(rsl::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public void startChat() {
        Scanner scanner = new Scanner(System.in);
        StringJoiner chat = new StringJoiner(System.lineSeparator());
        while (!status.equalsIgnoreCase("exit")) {
            System.out.println("Enter your question?");
            String input = scanner.nextLine();
            chat.add("User: " + input);
            if (!input.equalsIgnoreCase("stop")) {
                if (input.equalsIgnoreCase("exit")) {
                    status = "exit";
                } else {
                    chat.add("Chat " + createAnswer());
                    System.out.println(createAnswer());
                }
            } else {
                status = "stop";
                while (!status.equalsIgnoreCase("working")) {
                    System.out.printf("If you want me to answer your question please enter %s or %s to exit the chart"
                                    + System.lineSeparator(), "continue", "exit");
                    System.out.println("If you want just ask me something without answer, please enter your question?");
                    input = scanner.nextLine();
                    chat.add("User: " + input);
                    if (input.equalsIgnoreCase("continue")) {
                        status = "working";
                    }
                    if (input.equalsIgnoreCase("exit")) {
                        status = "exit";
                        break;
                    }
                }
            }
        }
        writeToFile(chat.toString());
    }

    private void writeToFile(String source) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(outPut))) {
            out.write(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String createAnswer() {
        return sourceText.get(new Random().nextInt(sourceText.size()));
    }

    public static void main(String[] args) {
        File text = new File("C:\\projects\\job4j_design\\chapter2-InputOutputSystem\\data\\data.txt");
        File chat = new File("C:\\projects\\job4j_design\\chapter2-InputOutputSystem\\data\\chat.txt");

        ConsoleChat consoleChat = new ConsoleChat(text, chat);
        consoleChat.startChat();
    }
}

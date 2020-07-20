package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgZip {
    private final String[] args;
    String[] keys = {"-d", "-e", "-o"};
    Map<String, String> instructions = new HashMap<>();

    public ArgZip(String[] args) {
        this.args = args;
    }

    private void getInstructions()  {
        for (String st : args) {
            if (st.contains("=")) {
                String[] keyValue = st.split("=");
                for (String string : keyValue) {
                    System.out.println(string);
                }
                instructions.put(keyValue[0], keyValue[1]);
            }
        }
    }

    public boolean valid() {
        getInstructions();
        boolean rsl = true;
        for (String key : keys) {
            if (!instructions.containsKey(key)) {
                rsl = false;
                System.out.println("Key: " + key + " is absent. Please add it to your command.");
            }
        }
        return rsl;
    }

    public String directory() {
        return instructions.get("-d");
    }

    public String exclude() {
        return instructions.get("-e");
    }

    public String output() {
        return instructions.get("-o");
    }
}

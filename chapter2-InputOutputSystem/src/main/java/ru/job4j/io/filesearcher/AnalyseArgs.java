package ru.job4j.io.filesearcher;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class AnalyseArgs {
    private final String[] args;
    private final List<String> keys = List.of("-d", "-n", "-o");
    private final List<String> searchKeys = List.of("-m", "-f", "-r");
    private String searchMode = null;
    private static Map<String, String> instructions = new HashMap<>();


    public AnalyseArgs(String[] args) {
        this.args = args;
    }

    private void getInstructions() {
        for (int i = 0; i < args.length; i++) {
            String value = args[i];
            if (value.startsWith("-") && keys.contains(value)) {
                instructions.put(value, args[++i]);
            } else if (value.startsWith("-") && searchKeys.contains(value)) {
                searchMode = value;
            }
        }
    }

    public boolean valid() {
        getInstructions();
        boolean result = true;
        if (searchMode == null) {
            System.out.println("Please specify correct search mode!!!");
            result = false;
        }
        for (String key : keys) {
            if (!instructions.containsKey(key)) {
                result = false;
                System.out.println("Key: " + key + " is absent. Please add it to your command.");
            }
        }
        return result;
    }

    public String directory() {
        return instructions.get("-d");
    }

    public String output() {
        return instructions.get("-o");
    }

    public String searchingCriteria() {
        return instructions.get("-n");
    }

    public String getSearchMode() {
        return searchMode;
    }

//    public static void main(String[] args) {
//        AnalyseArgs analyseArgs = new AnalyseArgs(args);
//        analyseArgs.getInstructions();
//        System.out.println(analyseArgs.searchMode);
//        for (String instruction : instructions.keySet()) {
//            System.out.println("key: " + instruction + " value: " + instructions.get(instruction));
//        }
//    }
}

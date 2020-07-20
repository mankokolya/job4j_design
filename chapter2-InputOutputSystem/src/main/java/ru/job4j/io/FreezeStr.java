package ru.job4j.io;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        String sortedLeft = sort(left);
        String sortedRight = sort(right);
        return sortedLeft.equals(sortedRight);
    }
    private static String sort(String data) {
        char[] sorted = data.toCharArray();
        Arrays.sort(sorted);
        return Arrays.toString(sorted);

    }
}

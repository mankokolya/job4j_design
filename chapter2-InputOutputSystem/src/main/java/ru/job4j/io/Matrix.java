package ru.job4j.io;

import java.io.FileOutputStream;

/**
 * Matrix - is used write multidimensional array of numbers to file by multiplying indexes on each other;
 *
 * @author mankokolya;
 */
public class Matrix {
    /**
     * @param size - the size of the multidimensional array;
     *
     */
    public static void multiple(int size) {
        try (FileOutputStream out = new FileOutputStream("multiplication.txt")) {
            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= size; j++) {
                    out.write(((i * j) + "\t").getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package cache;

import java.io.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadTextFromPC {

    public static void main(String[] args) {
        SoftReferenceCache<String, String> filesFromPc = new SoftReferenceCache<>();
        String namesFile = "./chapter4-JvmAndJmm/src/main/resources/Names.txt";
        String addressesFile = "./chapter4-JvmAndJmm/src/main/resources/Addresses.txt";

        Function<String, String> f = str -> {
            String st = null;
            try (BufferedReader reader = new BufferedReader(new FileReader(str))) {
                st = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return st;
        };
//        filesFromPc.put(namesFile, f);
        System.out.println(filesFromPc.get(namesFile, f));
        System.out.println(filesFromPc.get(addressesFile, f));

    }
}

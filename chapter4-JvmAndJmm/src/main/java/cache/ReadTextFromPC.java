package cache;

import java.io.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadTextFromPC {

    public static void main(String[] args) throws IOException {
        SoftReferenceCache<String, String> filesFromPc = new SoftReferenceCache<>();
        String namesFile = "./chapter4-JvmAndJmm/src/main/resources/Names.txt";
        String addressesFile = "./chapter4-JvmAndJmm/src/main/resources/Addresses.txt";

        Function<BufferedReader, String> f =
                (BufferedReader b) -> {
                    return b.lines().collect(Collectors.joining(System.lineSeparator()));
                };

        System.out.println(filesFromPc.get(namesFile, f);

    }
}

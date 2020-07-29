package ru.job4j.io.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class MappedChannelRead {
    public static void main(String[] args) {
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Path.of("text.txt"))) {
            long fSize = fileChannel.size();

            MappedByteBuffer mBuf = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

            for (int i = 0; i < fSize; i++) {
                System.out.println((char) mBuf.get());
            }
            System.out.println();

        } catch (InvalidPathException | IOException e) {
            e.printStackTrace();
        }
    }
}

package ru.job4j.io.nio;

import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;

        try (SeekableByteChannel byteChannel = Files.newByteChannel(Path.of("test.txt"))) {
            ByteBuffer buf = ByteBuffer.allocate(128);
            do {
                count = byteChannel.read(buf);

                if (count != -1) {
                    buf.rewind();
                }
                for (int i = 0; i < count; i++) {
                    System.out.println((char) buf.get());
                }
            } while (count != -1);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

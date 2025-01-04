package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "largefile.txt";
        byte[] inputBytes = {};
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        startTime = System.currentTimeMillis();
        StringBuffer outputStringBuffer = new StringBuffer();
        for (byte b : inputBytes) {
            outputStringBuffer.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thoi gian thuc hien StringBuffer: " + (endTime - startTime) + " ms");
    }
}
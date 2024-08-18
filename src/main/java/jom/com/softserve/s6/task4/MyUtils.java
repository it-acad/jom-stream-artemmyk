package jom.com.softserve.s6.task4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Locale;

public class MyUtils {

    public static String readFile(String filename) {

        try (var stream = new FileInputStream(filename)) {
            var builder = new StringBuilder();

            byte[] bytes;
            while (stream.available() > 0) {
                bytes = stream.readNBytes(7);
                String str = new String(bytes);
                int integer = Integer.parseInt(str, 2);
                char character = (char) integer;

                builder.append(character);
            }

            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

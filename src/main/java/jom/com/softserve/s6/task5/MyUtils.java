package jom.com.softserve.s6.task5;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class MyUtils {

    public Stream<String> nameList(Map<String, Stream<String>> map) {
        return map
                .values()
                .stream()
                .filter(Objects::nonNull)
                .reduce(Stream.empty(), Stream::concat)
                .filter(Objects::nonNull)
                .map(str -> str.replace(" ", ""))
                .filter(str -> !str.isEmpty())
                .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase())
                .distinct()
                .sorted();
    }

}

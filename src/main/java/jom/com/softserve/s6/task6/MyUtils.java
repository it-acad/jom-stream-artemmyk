package jom.com.softserve.s6.task6;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {

    public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        var regexPattern = "[\\s\\-\\[\\]\\(\\){}]";

        return list.stream() // Stream of Stream<String>
                .flatMap(stream -> stream.filter(Objects::nonNull)) // Flatten the list into a single Stream<String>
                .map(number -> number.replaceAll(regexPattern, "")) // Remove spaces, brackets, and dashes
                .filter(number -> !number.isEmpty()) // Filter out empty numbers
                .collect(Collectors.groupingBy(
                        number -> {
                            if (number.length() < 7) {
                                return "err";
                            } else if (number.length() == 7) {
                                return "loc";
                            } else {
                                return number.substring(0, 3);
                            }
                        },
                        TreeMap::new, // Use TreeMap to automatically sort the keys
                        Collectors.mapping(
                                number -> {
                                    if (number.length() > 7) {
                                        return number.substring(3); // Remove the prefix for network numbers
                                    }
                                    return number;
                                },
                                Collectors.toCollection(TreeSet::new) // Sort the phone numbers within each category
                        )
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream() // Convert the sorted set back to a stream
                ));
    }

}

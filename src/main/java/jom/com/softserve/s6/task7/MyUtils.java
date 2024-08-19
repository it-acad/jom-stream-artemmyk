package jom.com.softserve.s6.task7;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {

    public Stream<Integer> duplicateElements(Stream<Integer> stream) {
        var visited = new HashSet<Integer>();
        var saved = new HashSet<Integer>();
        return stream
                .filter(Objects::nonNull)
                .sorted()
                .filter(val -> {
                    if (visited.contains(val) && !saved.contains(val)) {
                        saved.add(val);
                        return true;
                    }

                    visited.add(val);

                    return false;
                });
    }

}

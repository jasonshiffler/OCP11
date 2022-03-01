package streams15;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminalOperations {

    public static void main(String[] args) {

        //count()
        long count = Stream.of("Hello", "Goodbye").count();

        //min()
        Optional<String> minResult = Stream.of("Hello", "Goodbye").min(Comparator.naturalOrder());

        //max()
        Optional<String> maxResult = Stream.of("Hello", "Goodbye").max(Comparator.naturalOrder());

        //All match
        boolean allMatchResult = Stream.of("Hello", "Goodbye").allMatch(String::isEmpty);

        //Any match result
        boolean anyMatchResult = Stream.of("Hello", "Goodbye").anyMatch(String::isEmpty);

        //None match result
        boolean noneMatchResult = Stream.of("Hello", "Goodbye").noneMatch(String::isEmpty);

        //ForEach
        Stream.of("Hello", "Goodbye").forEach(System.out::println);

        //Reduce
        String stringReduction = Stream.of("Hello", "Goodbye").reduce("", (s1,s2) -> s1 + s2);

        //Collect
        String collectionResult = Stream.of("Hello", "Goodbye").collect(Collectors.joining());
    }
}

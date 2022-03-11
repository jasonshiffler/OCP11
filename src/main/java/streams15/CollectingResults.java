package streams15;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {

    public static void main(String[] args) {
        groupingByExamples();
    }

    private static void collectFunctions() {
        String joinedStream = Stream.of("Hello", "goodbye").collect(Collectors.joining());
        String joinedStreamWithDelimiter = Stream.of("Hello", "goodbye").collect(Collectors.joining("+"));

        Optional<String> maxValue = Stream.of("Hello", "goodbye").collect(Collectors.maxBy(Comparator.naturalOrder()));
        Optional<String> minValue = Stream.of("Hello", "goodbye").collect(Collectors.minBy(Comparator.naturalOrder()));
    }

    private static void creatingCollectionsFromStreams() {
        Stream.of("Hello", "goodbye").collect(Collectors.toList());
        Stream.of("Hello", "goodbye").collect(Collectors.toSet());
        Stream.of("Hello", "goodbye").collect(Collectors.toCollection(LinkedList::new));
        Stream.of("Hello", "goodbye").collect(Collectors.toCollection(TreeSet::new));
    }

    //Grouping By - Optional Map Type Supplier to change Map Type Implementation and Downstream Collector to adjust the collection type within the Map
    //First argument of grouping by changes the key, second does the value
    private static void groupingByExamples() {
        Map<Integer, List<String>> groupedBy = Stream.of("Hello", "goodbye", "stuff").collect(Collectors.groupingBy(String::length));
        Map<Integer, Set<String>> groupedBySet = Stream.of("Hello", "goodbye", "stuff").collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        TreeMap<Integer, Set<String>> groupedTreeBySet = Stream.of("Hello", "goodbye", "stuff").collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));

        System.out.println(groupedBy);
        System.out.println(groupedBySet);
        System.out.println(groupedTreeBySet);

        //Can use a downstream collector to transform each collection if needed
        Map<Integer, Long> groupedByLong = Stream.of("Hello", "goodbye", "stuff").collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(groupedByLong);
    }

    private static void partitioningByExamples() {
        Map<Boolean, List<String>> partBy = Stream.of("Hello", "goodbye", "stuff").collect(Collectors.partitioningBy(str -> str.length() < 6));
        Map<Boolean, Set<String>> partBySet = Stream.of("Hello", "goodbye", "stuff").collect(Collectors.partitioningBy(str -> str.length() < 6, Collectors.toSet()));

        System.out.println(partBy);
        System.out.println(partBySet);
    }

    private static void collectMathOperations() {
        var averageDouble = Stream.of("Hello", "goodbye").collect(Collectors.averagingDouble(String::length));
        var averageInt = Stream.of("Hello", "goodbye").collect(Collectors.averagingInt(String::length));
        var averageLong = Stream.of("Hello", "goodbye").collect(Collectors.averagingLong(String::length));

        double sumDouble= Stream.of("Hello", "goodbye").collect(Collectors.summingDouble(String::length));
        int sumInt = Stream.of("Hello", "goodbye").collect(Collectors.summingInt(String::length));
        long sumLong= Stream.of("Hello", "goodbye").collect(Collectors.summingLong(String::length));

        var doubleSummaryStatistics = Stream.of("Hello", "goodbye").collect(Collectors.summarizingDouble(String::length));
        var intSummaryStatistics = Stream.of("Hello", "goodbye").collect(Collectors.summarizingInt(String::length));
        var longSummaryStatistics = Stream.of("Hello", "goodbye").collect(Collectors.summarizingLong(String::length));

        long numElements = Stream.of("Hello", "goodbye").collect(Collectors.counting());
    }


}


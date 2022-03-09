package streams15;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {

    public static void main(String[] args) {

        //Creating Collections
        Stream.of("Hello", "goodbye").collect(Collectors.toList());
        Stream.of("Hello", "goodbye").collect(Collectors.toSet());
        Stream.of("Hello", "goodbye").collect(Collectors.toCollection(LinkedList::new));
        Stream.of("Hello", "goodbye").collect(Collectors.toCollection(TreeSet::new));

        String joinedStream = Stream.of("Hello", "goodbye").collect(Collectors.joining());
        String joinedStreamWithDelimiter = Stream.of("Hello", "goodbye").collect(Collectors.joining("+"));

        Optional<String> maxValue = Stream.of("Hello", "goodbye").collect(Collectors.maxBy(Comparator.naturalOrder()));
        Optional<String> minValue = Stream.of("Hello", "goodbye").collect(Collectors.minBy(Comparator.naturalOrder()));

        //Math Collection Operations
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

        //Grouping By - Optional Map Type Supplier and Downstream Collector
        var groupedBy = Stream.of("Hello", "goodbye", "thing", "stuff").collect(Collectors.groupingBy(String::length));
        var groupedBySet = Stream.of("Hello", "goodbye", "thing", "stuff").collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        var groupedTreeBySet = Stream.of("Hello", "goodbye", "thing", "stuff").collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));


    }
}


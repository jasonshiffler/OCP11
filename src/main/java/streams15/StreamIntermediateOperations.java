package streams15;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOperations {

    public static void main(String[] args) {

        //Stream<T> filter(Predicate<? super T> predicate) - takes a Predicate
        List<String> filterResults = Stream.of("Hello", "Goodbye").filter(s -> s.startsWith("H")).collect(Collectors.toList());

        //Stream<T> distinct() - calls .equals()
        List<String> distinctResults = Stream.of("Hello", "Goodbye", "Hello").distinct().collect(Collectors.toList());

        //Stream<T> limit(long maxSize) - makes a stream smaller or converts an infinite stream
        List<Double> limitList = Stream.generate(Math::random).limit(5).collect(Collectors.toList());

        //Stream<T> skip(long n) - skips the first n results
        List<Double> skipList = Stream.generate(Math::random).skip(5).limit(5).collect(Collectors.toList());

        //Stream<T> map(Function<? super T, ? extends R> mapper) - takes a Function
        List<Integer> mapResults = Stream.of("Hello", "Goodbye").map(String::length).collect(Collectors.toList());

        //Stream<R> map(Function<? super T, ? extends Stream<? extends R>> mapper) - takes a Function
        Stream.of(List.of("Hello", "Goodbye"), List.of("Hello", "Goodbye"))
                .flatMap(x -> x.stream())
                .forEach(System.out::println);

        //Stream<T> sorted() - sorts a steram usi
        Stream.of("Zoo", "Car","Bike", "Plane")
                .sorted()
                .forEach(System.out::println);

        //Stream<T> sorted(Comparator <? super T> comparator)
        Stream.of("Zoo", "Car","Bike", "Plane")
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        //Stream<T> peek(Consumer <? super T> action)
        Stream.of("Zoo", "Car","Bike", "Plane")
                .peek(System.out::println)
                .sorted(Comparator.reverseOrder())
                .peek(System.out::println)
                .collect(Collectors.joining());
    }
}

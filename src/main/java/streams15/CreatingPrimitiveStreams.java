package streams15;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreatingPrimitiveStreams {

    public static void main(String[] args) {

        DoubleStream.empty();
        IntStream.empty();
        LongStream.empty();

        DoubleStream.of(1.3, 6.55, 34, 2.43);

        IntStream.of(1,2,3,4,5);
        IntStream.range(1, 9);
        IntStream.rangeClosed(1, 9);

        LongStream.of(1L, 2L, 3L, 4L, 45L);
        LongStream.range(1,9);
        LongStream.rangeClosed(1, 9);

        DoubleStream.generate(Math::random).limit(10);
        IntStream.generate(() -> 4).limit(10);
        LongStream.generate(() -> 4L);

        DoubleStream.iterate(1000, d -> d/2).parallel().limit(10);
        IntStream.iterate(1, x -> x * 2).limit(50);
        LongStream.iterate(1L, x -> x * 2).limit(50);

        //Mapping from another Stream Type
        IntStream intStreamFromMap = Stream.of("Bob", "Steve", "Troy", "Carter").mapToInt(String::length);
        LongStream longStreamFromMap = Stream.of("Bob", "Steve", "Troy", "Carter").mapToLong(String::length);
        DoubleStream doubleStreamFromMap = Stream.of("Bob", "Steve", "Troy", "Carter").mapToDouble(String::length);

        //Converting a primitive stream to a Stream type using mapToObj
        Stream<Integer> integerStream = IntStream.rangeClosed(1, 9).mapToObj(Integer::valueOf);

    }
}

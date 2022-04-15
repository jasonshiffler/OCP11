package streams15;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreamOperations {

    public static void main(String[] args) {

        //Average
        OptionalDouble optionalDouble1 = DoubleStream.of(3.3, 4.3, 1.9, 34.86).average();
        OptionalDouble optionalDouble2 = IntStream.of(1, 4, 4, 44).average();
        OptionalDouble optionalDouble3 = LongStream.of(1L, 4L, 4L, 44L).average();
        optionalDouble1.getAsDouble();

        //Max
        optionalDouble1 = DoubleStream.of(3.3, 4.3, 1.9, 34.86).max();
        OptionalInt optionalInt = IntStream.of(1, 4, 4, 44).max();
        OptionalLong optionalLong =  LongStream.of(1L, 4L, 4L, 44L).max();
        optionalInt.getAsInt();
        optionalLong.getAsLong();

        //Min
        optionalDouble1 = DoubleStream.of(3.3, 4.3, 1.9, 34.86).min();
        optionalInt = IntStream.of(1, 4, 4, 44).min();
        optionalLong =  LongStream.of(1L, 4L, 4L, 44L).min();

        //Sum
        double doubleSum = DoubleStream.of(3.3, 4.3, 1.9, 34.86).sum();
        int intSum = IntStream.of(1, 4, 4, 44).sum();
        long longSum = LongStream.of(1L, 4L, 4L, 44L).sum();

    }
}

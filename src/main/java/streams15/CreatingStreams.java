package streams15;

import java.util.List;
import java.util.stream.Stream;

public class CreatingStreams {

    public static void main(String[] args) {

        //An Empty Stream
        Stream.empty();

        //A stream from varargs
        Stream.of(List.of("Hello"), List.of("World","!"));

        //Using stream() to create a stream from a collection
        List.of("What's up!").stream().count();

        //Creating a parallel stream from a collection
        List.of("What's up!").parallelStream().count();

        //Transforming a stream to a parallel stream.
        List.of("What's up!").stream().parallel().count();

        //Dumb but legal
        List.of("What's up!").stream().parallel().parallel().count();

        //Infinite stream using a supplier and trimmed down to finite with a limit
        Stream.generate(Math::random).limit(4L);

        //Infinite Stream with iterate
        Stream.iterate(0, num -> num * 2);

        //iterate stream limited with a Predicate
        Stream.iterate(0, num -> num < 500, num -> num * 2);
    }

}

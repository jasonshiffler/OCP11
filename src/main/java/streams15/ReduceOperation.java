package streams15;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ReduceOperation {

    public static void main(String[] args) {
        threeParamReducerSerial();

    }

    //Has an identity value and an accumulator
    private void twoParamReducer() {
        Stream.of("Hello", "Goodbye").reduce("", (s1, s2) -> s1 + s2);
    }

    //Has a single accumulator, if the stream is empty returns Optional empty, if the stream has one value returns
    //an Optional of the value, and if the stream has more than one value the accumulator is used to combine.
    private void oneParamReducer() {
        Optional<String> result = Stream.of("Hello", "Goodbye").reduce((s1, s2) -> s1 + s2);
    }

    //Has an identity value, accumulator, and combiner. Useful for parallel reductions. The accumulator can handle
    //mixed data types if needed using the identity value and each value from the stream. The combiner operates on
    //of the results from the accumulator operations
    //Accumulator - Executes a BiFunction using the identity and each stream value
    //Combiner - Executes a BinaryOperator to merge the accumulator results from the different threads into a single result.
    private static void threeParamReducer() {
        int result = Stream.of("Hello", "Goodbye")
                .parallel()
                .reduce(0, (i, s) -> i + s.length(), (s1, s2) -> s1 + s2 );
    }

    //Accumulator results: "identityHello", "identityGoodbye"
    //Combiner result: "identityHelloidentityGoodbye"
    private static void threeParamReducer2() {
        String result = List.of("Hello", "Goodbye")
                .parallelStream()
                .reduce("identity", (i, s) -> i + s, (s1, s2) -> s1 + s2 );

        System.out.println(result);
    }

    //Accumulator results: "identityHelloGoodbye". The accumulator operates on all the data within a single thread
    //Combiner result: Since this is a single threaded stream there is only one thread the combiner never runs since
    //its function is to combine the results from different threads.

    private static void threeParamReducerSerial() {
        String result = Stream.of("Hello", "Goodbye")
                .reduce("identity", (i, s) -> {
                    System.out.println("Accumulator - Runs twice");
                    return i + s;
                }, (s1, s2) -> {
                    System.out.println("Combiner - Never runs");
                    return s1 + s2;
                });

        System.out.println(result);
    }
}

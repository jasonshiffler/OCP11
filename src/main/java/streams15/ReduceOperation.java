package streams15;

import java.util.Optional;
import java.util.stream.Stream;

public class ReduceOperation {

    public static void main(String[] args) {
      
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
    //mixed data types if needed using the identity value and each value from the stream. The combiner operators on all
    //of the results from the accumulator operations
    //Accumulator - performs an operation on the identity and each stream value
    //Combiner - performs operations on all of the accumulator results.
    private static void threeParamReducer() {
        int result = Stream.of("Hello", "Goodbye")
                .parallel()
                .reduce(0, (i, s) -> i + s.length(), (s1, s2) -> s1 + s2 );
    }

    //Accumulator results: "identityHello", "identityGoodbye"
    //Combiner result: "identityHelloidentityGoodbye"
    private static void threeParamReducer2() {
        String result = Stream.of("Hello", "Goodbye")
                .parallel()
                .reduce("identity", (i, s) -> i + s, (s1, s2) -> s1 + s2 );

        System.out.println(result);
    }
}

package streams15;

import java.util.Optional;

public class ChainingOptionals {

    public static void main(String[] args) {
        Optional.of("Hello")
                .map(String::length)
                .filter(str -> str > 3)
                .orElse(1);

        //Flat map can be used to convert an Optional<Optional<R>> -> Optional<R>
        Optional.of("Hello")
                .flatMap(x -> Optional.of(x+3))
                .filter(x -> x.length() > 4)
                .orElse("Hello");

    }
}

package streams15;

import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {
        creatingOptionals();

    }

    private static void creatingOptionals() {
        Optional<Integer> optionalInteger1 = Optional.empty();
        Optional<Integer> optionalInteger2 = Optional.of(5);

        //Wraps an Optional if not null, returns Optional.empty() otherwise
        Optional<Integer> optionalInteger3 =  Optional.ofNullable(null);

        //Throws a NoSuchElement exception if a get is performed on an empty Optional. Returns the value otherwise.
        optionalInteger3.get();

        //Returns false if empty.
        optionalInteger3.isPresent();

        //Returns the value or other parameter if empty
        optionalInteger3.orElse(5);

        //Returns the value or result of Supplier which must be the same type.
        optionalInteger3.orElseGet( () -> 5 );

        //The value or a NoSuchElementException
        optionalInteger3.orElseThrow();

        //The value or the exception provided by the Supplier
        optionalInteger3.orElseThrow(IllegalArgumentException::new);


    }
}

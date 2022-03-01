package streams15;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BultinFunctionalInterfaces {

    public static void main(String[] args) {

        //Supplier, 0 param, Generic Return
        Supplier<String> stringSupplier = () -> "Hello Supplier";
        stringSupplier.get();

        //Consumer, 1 param, no return
        Consumer<String> stringConsumer = str -> System.out.println(str);
        stringConsumer.accept("Hello");

        //BiConsumer, 2 param, no return
        BiConsumer<String, String> biConsumer = (str1, str2) -> System.out.println(str1 + str2);
        biConsumer.accept("Hello", "World");

        //Predicate, 1 param, boolean return
        Predicate<Integer> predicate = x -> x > 5;
        predicate.test(6);

        //BiPredicate, 2 param, boolean return
        BiPredicate<Integer, String> biPredicate = (Integer num, String str) -> str.length() > num;

        //Function, 1 param, Generic Return
        Function<Integer, String> function = num -> num + "Hello!";
        function.apply(4);

        //BiFunction, 2 param, Generic Return
        BiFunction<Integer, Long, String> biFunction = (intNum, longNum) -> "Hello" + intNum + longNum;
        biFunction.apply(3,4L);

        //Unary Operator, 1 param, same return type
        UnaryOperator<Integer> unaryOperator = num -> num - 1;
        unaryOperator.apply(5);

        //Binary Operator, 2 param, same return type
        BinaryOperator<Integer> binaryOperator = (num1, num2) -> num1 + num2;
        binaryOperator.apply(5,6);
    }

}

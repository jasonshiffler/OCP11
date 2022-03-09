package streams15;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongUnaryOperator;

public class PrimitiveFunctionalInterfaces {

    public static void main(String[] args) {

        DoubleSupplier doubleSupplier = () -> 3.14;
        IntSupplier intSupplier = () -> 3;
        LongSupplier longSupplier = () -> 3L;

        DoubleConsumer doubleConsumer = (double d) -> System.out.println(d + 1);
        IntConsumer intConsumer = (int s) -> System.out.println(s + 1);
        LongConsumer longConsumer = (long l) -> System.out.println(l + 1);

        DoublePredicate doublePredicate = (double d) -> true;
        IntPredicate intPredicate = (int i) -> true;
        LongPredicate longPredicate = (long l) -> true;

        DoubleFunction doubleFunction = (double d) -> "DoubleFunction";
        IntFunction intFunction = (int i) -> "IntFunction";
        LongFunction longFunction = (long l) -> "LongFunction";

        DoubleUnaryOperator doubleUnaryOperator = (double d) -> d;
        IntUnaryOperator intUnaryOperator = (int i) -> i;
        LongUnaryOperator longUnaryOperator = (long l) -> l;

        DoubleBinaryOperator doubleBinaryOperator = (double d, double D) -> d + D;
        IntBinaryOperator intBinaryOperator = (int i, int I) -> i + I;
        LongBinaryOperator longBinaryOperator = (long l, long L) -> l + L;
    }
}

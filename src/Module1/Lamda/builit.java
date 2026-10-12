package Module1.Lamda;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class builit {



        public static void main(String[] args) {
            Supplier<Integer> numberSupplier = () -> 24;

            Predicate<Integer> isEven = (num) -> num % 2 == 0;

            Function<Integer, String> getEvenOddLabel = (num) -> isEven.test(num) ? num + " is Even" : num + " is Odd";

            Consumer<String> printer = (message) -> System.out.println(message);

            int number = numberSupplier.get();

            System.out.println("Predicate test: Is " + number + " even? " + isEven.test(number));

            String outputMessage = getEvenOddLabel.apply(number);
            printer.accept(outputMessage);

            int oddTest = 15;
            printer.accept(getEvenOddLabel.apply(oddTest));
        }
    }

package Comparator;

import java.util.Comparator;
import java.util.List;

public class SampleComparator {

    public static void main(String[] args) {
     //Lambdas allow for the creation of a type safe comparator
        Comparator<Person> personComparator = Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName)
                .thenComparing(Person::middleName)
                .thenComparingInt(Person::age);

        List.of(new Person("Jason", "Gregory","Shiffler", 44),
                new Person("Steve", "Ace","Miller", 72),
                new Person("Allen", "Mace","Jackson", 37),
                new Person("George", "","Jackson", 28),
                new Person("Yannis", "Des","Soouvi", 44))
                .stream()
                .sorted(personComparator)
                .forEach(System.out::println);
    }
}
record Person(String firstName, String middleName, String lastName, int age) { }
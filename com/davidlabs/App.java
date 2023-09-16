package com.davidlabs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        IPrintable<String> printThis = (String) -> System.out.println(String);
        printThis.print("Printable Lambda");
        
        Consumer<String> printThat = System.out::println;
        printThat.accept("Printable Lambda");

        IRetrievble<Integer> retrieverLambda = () -> {return 77;};
        System.out.println(retrieverLambda.retrieve());

        Supplier<Integer> supplierRLambda = () -> {return 77;};
        System.out.println(supplierRLambda.get());

        IEvaluate<Integer> evaluateLambda = i -> i<0;
        System.out.println(evaluateLambda.isNegative(43));
        System.out.println(evaluateLambda.isNegative(-43));

        Predicate<Integer> predicateLambda = i -> i<0;
        System.out.println(predicateLambda.test(43));
        System.out.println(predicateLambda.test(-43));

        Predicate<Integer> integerPredicate = (integer) -> integer%2==0;
        System.out.println("3c1 " + check(4,integerPredicate));
        System.out.println("3c1 " + check(7,integerPredicate));

        Predicate<String> beginsWithMr = (string) -> string.startsWith("Mr.");
        Predicate<String> beginsWithMs = (string) -> string.startsWith("Ms.");
        System.out.println("3c2 "+check("Mr. Joe Bloggs",beginsWithMr));
        System.out.println("3c2 "+check("Ms. Ann Bloggs",beginsWithMs));

        Predicate<Person> personWithAge = (person) -> person.age >=18;

        Person Mike = new Person(1.8,33);
        Person Ann = new Person(1.4,13);

        System.out.println("3c3 " + check(Mike, personWithAge));
        System.out.println("3c3 " + check(Ann, personWithAge));

        IFunctionable<Integer> func = (integer) -> {return "Number is " + integer; };
        System.out.println(func.applyThis(25));

        Function<Integer,String> func2 = (integer) -> { return "Number is " + integer;};
        System.out.println(func2.apply(26));

        List<Person> listPeople = getPeople();

        System.out.println("*******     SORT BY AGE LAMBDA      *******");
        sortAgeLambda(listPeople);
        listPeople.forEach(System.out::println);
        System.out.println("*******     SORT BY NAME LAMBDA     *******");
        sortNameLambda(listPeople);
        listPeople.forEach(System.out::println);
        System.out.println("*******     SORT BY HEIGHT LAMBDA     *******");
        sortHeightLambda(listPeople);
        listPeople.forEach(System.out::println);
        
        System.out.println("*******     SORT BY AGE       *******");
        sortAge(listPeople);
        listPeople.forEach(System.out::println);
        System.out.println("*******     SORT BY NAME       *******");
        sortName(listPeople);
        listPeople.forEach(System.out::println);
        System.out.println("*******     SORT BY HEIGHT      *******");
        sortHeight(listPeople);
        listPeople.forEach(System.out::println);
    }   
    public static<T,U> boolean check(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }

    private static void sortAgeLambda(List<Person> persons) {
        persons.sort(Comparator.comparing(person -> person.getAge()));
    }


    private static void sortNameLambda(List<Person> persons) {
        persons.sort(Comparator.comparing(person -> person.getName()));
    }

    private static void sortHeightLambda(List<Person> persons) {
        persons.sort(Comparator.comparing(person -> person.getHeight()));
    }

    private static void sortAge(List<Person> persons) {
        persons.sort(Comparator.comparing(Person::getAge));
    }   

    private static void sortName(List<Person> persons) {
        persons.sort(Comparator.comparing(Person::getName));
    } 

    private static void sortHeight(List<Person> persons) {
        persons.sort(Comparator.comparing(Person::getHeight));
    } 
}

package com.davidlabs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiPredicate;
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
        //printThis.print("Printable Lambda");
        
        Consumer<String> printThat = System.out::println;
        //printThat.accept("Printable Lambda");

        IRetrievble<Integer> retrieverLambda = () -> {return 77;};
        //System.out.println(retrieverLambda.retrieve());

        Supplier<Integer> supplierRLambda = () -> {return 77;};
        //System.out.println(supplierRLambda.get());

        IEvaluate<Integer> evaluateLambda = i -> i<0;
        //System.out.println(evaluateLambda.isNegative(43));
        //System.out.println(evaluateLambda.isNegative(-43));

        Predicate<Integer> predicateLambda = i -> i<0;
        //System.out.println(predicateLambda.test(43));
        //System.out.println(predicateLambda.test(-43));

        Predicate<Integer> integerPredicate = (integer) -> integer%2==0;
        //System.out.println("3c1 " + check(4,integerPredicate));
        //System.out.println("3c1 " + check(7,integerPredicate));

        Predicate<String> beginsWithMr = (string) -> string.startsWith("Mr.");
        Predicate<String> beginsWithMs = (string) -> string.startsWith("Ms.");
        //System.out.println("3c2 "+check("Mr. Joe Bloggs",beginsWithMr));
        //System.out.println("3c2 "+check("Ms. Ann Bloggs",beginsWithMs));

        Predicate<Person> personWithAge = (person) -> person.age >=18;

        Person Mike = new Person(1.8,33);
        Person Ann = new Person(1.4,13);

        //System.out.println("3c3 " + check(Mike, personWithAge));
        //System.out.println("3c3 " + check(Ann, personWithAge));

        IFunctionable<Integer> func = (integer) -> {return "Number is " + integer; };
        //System.out.println(func.applyThis(25));

        Function<Integer,String> func2 = (integer) -> { return "Number is " + integer;};
        //System.out.println(func2.apply(26));

        List<Person> listPeople = getPeople();

        //System.out.println("*******     SORT BY AGE LAMBDA      *******");
        sortAgeLambda(listPeople);
        //listPeople.forEach(System.out::println);
        //System.out.println("*******     SORT BY NAME LAMBDA     *******");
        sortNameLambda(listPeople);
        //listPeople.forEach(System.out::println);
        //System.out.println("*******     SORT BY HEIGHT LAMBDA     *******");
        sortHeightLambda(listPeople);
        //listPeople.forEach(System.out::println);
        
        //System.out.println("*******     SORT BY AGE       *******");
        sortAge(listPeople);
        //listPeople.forEach(System.out::println);
        //System.out.println("*******     SORT BY NAME       *******");
        sortName(listPeople);
        //listPeople.forEach(System.out::println);
        //System.out.println("*******     SORT BY HEIGHT      *******");
        sortHeight(listPeople);
        //listPeople.forEach(System.out::println);
        List<Integer> integerList = new ArrayList<Integer>();
        staticMR(integerList);

        Consumer<List<Integer>> consumer = (list) -> Collections.sort(list);
        consumer.accept(integerList);
        //integerList.forEach(System.out::println);

        staticMR(integerList);
        //integerList.forEach(System.out::println);
        Consumer<List<Integer>> consumerMR = Collections::sort;
        consumerMR.accept(integerList);
        //integerList.forEach(System.out::println);

        String name= "Mr. Joe Bloggs";
        Predicate<String> startsWithMr = (string) -> string.startsWith("Mr.");
        //System.out.println(startsWithMr.test(name));
        //System.out.println(startsWithMr.test("Ms. Hoe Bloggs"));
        Predicate<String> startsWithMrMR = name::startsWith;
        //System.out.println(startsWithMrMR.test("Ms."));

        Predicate<String> containsLambda = (string) -> string.toLowerCase().contains("joe");
        //System.out.println("11 " + containsLambda.test("Joey from friends"));
        //System.out.println(containsLambda.test("Chandler from friends"));

        name = "Joey";
        Predicate<String> containsMRV = name.toLowerCase()::contains;
        //System.out.println(containsMRV.test("joe"));
        //System.out.println(containsMRV.test("Chandler"));

        Predicate<String> emptyL = (string) -> string.isEmpty();
        //System.out.println(emptyL.test(""));
        //System.out.println(emptyL.test("xyz"));

        Predicate<String> emptyMR = String::isEmpty;
        //System.out.println(emptyMR.test(""));
        //System.out.println(emptyMR.test("xyz"));

        BiPredicate<String, String> emptyLBP = (string1,string2) -> string1.contains(string2);
        //System.out.println(emptyLBP.test("Mr. Joe Bloggs", "Mr."));
        //System.out.println(emptyLBP.test("Mr. Joe Bloggs", "Ms."));

        BiPredicate<String, String> emptyLBPMR = String::contains;
        //System.out.println(emptyLBPMR.test("Mr. Joe Bloggs", "Mr."));
        //System.out.println(emptyLBPMR.test("Mr. Joe Bloggs", "Ms."));


        Supplier<List<String>> supp = () -> new ArrayList<String>();
        List<String> l = supp.get();
        l.add("Lambda");
        //System.out.println(l);

        Supplier<List<String>> supp2 = ArrayList<String> :: new;
        List<String> l2 = supp2.get();
        l2.add("Method Reference");
        //System.out.println(l2);

        Function<Integer, List<String>> functionList = (integer) -> new ArrayList<String>(integer);
        List<String> list= functionList.apply(20);
        list.add("Lambda");
        //System.out.println(list);
        Function<Integer, List<String>> functionList2 = ArrayList::new;
        List<String> list2 = functionList2.apply(20);
        list2.add("method reference");
        //System.out.println(functionList2);


        //Streams . Chapter 2.
        

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

    public static void staticMR(List<Integer> integerList) {
            // Add values 1, 2, 7, 4, and 5 to the provided list
            integerList.add(1);
            integerList.add(2);
            integerList.add(7);
            integerList.add(4);
            integerList.add(5);
    }

    public static void boundMR(String s) {
        s= "Mr. Joe Bloggs";
    }
}

package Lecture_14_15;

import org.testng.annotations.Test;
import patterns.PersonBuilder;
import patterns.Singleton;
import сomparator.Person;
import сomparator.PriceCompare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture_14_15 {

    @Test
    public void compare_1() {
        Person person1 = new Person(14, "User 1");
        Person person2 = new Person(12, "User 2");
        Person person3 = new Person(14, "User 3");
        Person person4 = new Person(11, "User 4");
        Person person5 = new Person(20, "User 5");
        Person person6 = new Person(30, "User 6");
        Person person7 = new Person(44, "User 7");
        Person person8 = new Person(12, "User 8");

        List<Person> people = new ArrayList<>() {{
            add(person1);
            add(person2);
            add(person3);
            add(person4);
            add(person5);
            add(person6);
            add(person7);
            add(person8);
        }};

        PriceCompare priceCompare = new PriceCompare();
        people.sort(priceCompare);
        people.forEach(System.out::println);
    }


    @Test
    public void compare_2() {
        List<String> data = new ArrayList<>() {{
            addAll(Arrays.asList("1","2","1","1","3","1","1","1","1","8","1"));
        }};

        data.sort(((o1, o2) -> o1.compareTo(o2)));
        Collections.sort(data);
        data.forEach(System.out::println);
    }

    @Test
    public void patterns(){
        // Singleton
        Singleton singleton = Singleton.getInstance("FOO");
        Singleton anotherSingleton = Singleton.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
        // Builder
        PersonBuilder myPerson1 = new PersonBuilder.Builder()
                .withName("Jane")
                .withSurname("Doe")
                .withAge(32)
                .withHeight(165)
                .withWeight(70)
                .build();

        PersonBuilder myPerson2 = new PersonBuilder.Builder().build();


        System.out.println(myPerson1);
        System.out.println(myPerson2);
    }
}

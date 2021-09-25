package Lecture_14;

import comparator.Person;
import comparator.Sort;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Lecture_14 {

    @Test
    public void test() {
        Person person1 = new Person("Person 1", 23);
        Person person2 = new Person("Person 2", 44);
        Person person3 = new Person("Person 3", 33);
        Person person4 = new Person("Person 4", 32);
        Person person5 = new Person("Person 5", 23);
        Person person6 = new Person("Person 6", 30);
        Person person7 = new Person("Person 7", 33);

        List<Person> people = new ArrayList<>() {{
            add(person1);
            add(person2);
            add(person3);
            add(person4);
            add(person5);
            add(person6);
            add(person7);
        }};

        Sort sort = new Sort();
        people.sort(sort);
        people.forEach(System.out::println);
    }

    @Test
    public void test1() {
        List<Integer> data = new ArrayList<>() {{
            addAll(Arrays.asList(1, 3, 5, 11, 4, 3, 2, 1, 5, 67, 8));
        }};
        data.sort(Comparator.reverseOrder());
        data.forEach(System.out::println);


        Collections.sort(data);
        data.forEach(System.out::println);
        Collections.shuffle(data);
        data.forEach(System.out::println);

        List<Integer> data1 = data.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

    }

    @Test
    public void test2() {
      //PersonBuilder personBuilder = new PersonBuilder.Builder().withName("User").build();
      register(new PersonBuilder.Builder().build());
    }


    public void register(String name, Integer age, Integer phoneNumber, Boolean pets) {
        System.out.println(name);
        System.out.println(age);
        System.out.println(phoneNumber);
        System.out.println(pets);
    }

    public void register(PersonBuilder user) {
        System.out.println(user.name);
        System.out.println(user.sex);
        System.out.println(user.phoneNumber);
        System.out.println(user.lastName);
    }

    public void auth(User user) {
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.phoneNumber);
        System.out.println(user.getPets());
    }

}

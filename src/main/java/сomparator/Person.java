package сomparator;

import java.util.Comparator;

public class Person {
    Integer age;
    String name;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


}

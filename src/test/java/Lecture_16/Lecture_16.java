package Lecture_16;

import lombok.Car;
import lombok.Dog;
import lombok.User;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class Lecture_16 {

    @Test
    public void test1() {
        User user = User.builder().name("Test").age(22).sex("Male").build();
        System.out.println(user);
    }

    @Test
    public void test2() {
        Dog dog = new Dog();
        dog.setAge(3);
        dog.setType("Simple");
        System.out.println(dog);
    }

    @Test
    public void test3() {
        //Audi car
        Car audi = new Car();
        audi.setModel("Audi");
        audi.setEngine(1.6);
        //Wag car
        Car wv = new Car();
        wv.setModel("Wag");
        wv.setEngine(2.0);
        //New Audi car
        Car newAudi = new Car();
        newAudi.setModel("Wag");
        newAudi.setEngine(1.6);
        //models
        log.info(audi);
        log.info(wv);
        //hashCode
        log.info(audi.hashCode());
        log.info(wv.hashCode());
        //equals
        log.info(audi.equals(newAudi));
        newAudi.setModel("Audi");
        log.info(audi.equals(newAudi));
    }
}

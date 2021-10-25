package Lecture_23;

import org.testng.annotations.Test;

public class Lecture_23 extends AbstractClass {

    @Test
    public void test() {
        setName();
        System.out.println(super.getName());
        UserInterface.getUserName();
    }

    @Override
    public void setName() {
        super.name = "Test";
    }

}

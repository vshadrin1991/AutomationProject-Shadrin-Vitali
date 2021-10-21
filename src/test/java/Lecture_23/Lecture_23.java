package Lecture_23;

import org.testng.annotations.Test;

public class Lecture_23 extends AbstractClass{

    @Test
    public void test(){
        setName();
        System.out.println(getName());
    }

    @Override
    public void setName() {
        super.name = "Vitali";
    }
}

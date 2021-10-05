package Lecture_18;

import org.testng.annotations.Test;

public class Generics_Test {

    @Test
    public void test() {
        Robot<String> srobot = new Robot<>("robot");
        System.out.println(srobot);

        Robot<Double> irobot = new Robot<>(1.1);
        System.out.println(irobot);

        IBot iBot = new IBot("robot new");
        iBot.getName();
    }
}

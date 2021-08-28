package Lecture_10;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class BeforeAfter {
    List<String> list = new ArrayList<>();

    @BeforeSuite(groups = {"Lecture_10"})
    public void beforeSuite() {
        list.add("BeforeSuite");
    }

    @BeforeGroups("Lecture_10")
    public void beforeGroups() {
        list.add("BeforeGroups");
    }

    @BeforeTest(groups = {"Lecture_10"})
    public void beforeTest() {
        list.add("BeforeTest");
    }

    @BeforeClass(groups = {"Lecture_10"})
    public void beforeClass() {
        list.add("BeforeClass");
    }

    @BeforeMethod(groups = {"Lecture_10"})
    public void beforeMethod() {
        list.add("BeforeMethod");
    }

    @Test(groups = {"Lecture_10"})
    public void test1() {
        list.forEach(System.out::println);
    }

    @Test(groups = {"Lecture_10"})
    public void test2() {
        System.out.println("=======================================");
        list.forEach(System.out::println);
    }

    @AfterSuite(groups = {"Lecture_10"})
    public void afterSuite() {
        list.add("AfterSuite");
        System.out.println("=======================================");
        list.forEach(System.out::println);
    }

    @AfterGroups("Lecture_10")
    public void afterGroups() {
        list.add("AfterGroups");
    }

    @AfterTest(groups = {"Lecture_10"})
    public void afterTest() {
        list.add("AfterTest");
    }

    @AfterClass(groups = {"Lecture_10"})
    public void afterClass() {
        list.add("AfterClass");
    }

    @AfterMethod(groups = {"Lecture_10"})
    public void afterMethod() {
        list.add("AfterMethod");
    }

}

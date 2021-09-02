package Lecture_10;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lecture_10_2 {
    List<String> list = new ArrayList<>();

    @Test(dependsOnMethods = "test3")
    public void test1() {
        Assert.assertTrue(list.isEmpty());
    }

    @Test(enabled = false)
    public void test2() {
        Assert.assertTrue(list.isEmpty());
    }

    @Test(timeOut = 4000)
    public void test3() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(list.isEmpty());
    }

    @Test(dependsOnMethods = "test1")
    public void test4() {
        Assert.assertTrue(list.isEmpty());
    }

    @Test(dependsOnMethods = "test4", invocationCount = 3)
    public void test5() {
        list.add("123");
        System.out.println(list);
    }

    @Test(dependsOnMethods = "test5", expectedExceptions = {AssertionError.class})
    public void test6() {
        Assert.assertTrue(list.isEmpty());
    }

}

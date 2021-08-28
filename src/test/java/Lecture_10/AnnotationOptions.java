package Lecture_10;

import driver.Retry;
import driver.SetUpTearDown;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Listeners(SetUpTearDown.class)
public class AnnotationOptions {
    List<String> list = new ArrayList<>();

    @Test
    public void test1() {
        Assert.assertFalse(list.isEmpty());
    }

    @Test(enabled = false, timeOut = 1)
    public void test2() throws Exception {
        Thread.sleep(2000);
        Assert.assertFalse(list.isEmpty());
    }

    @Test(timeOut = 3000)
    public void test3() throws Exception {
        Thread.sleep(1000);
        Assert.assertTrue(list.isEmpty());
    }

    @Test(dependsOnMethods = {"test1"}, alwaysRun = true)
    public void test5() {
        Assert.assertTrue(list.isEmpty());
    }

    @Test(invocationCount = 3, threadPoolSize = 3)
    public void test6() {
        Assert.assertTrue(list.isEmpty());
    }

    @Test(expectedExceptions = {AssertionError.class})
    public void test7() {
        Assert.assertFalse(list.isEmpty());
    }

    @Test(retryAnalyzer = Retry.class)
    public void test8() {
        Assert.assertFalse(list.isEmpty());
    }
}

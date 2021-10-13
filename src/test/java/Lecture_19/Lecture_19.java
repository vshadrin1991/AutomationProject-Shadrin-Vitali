package Lecture_19;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testng.Listener;

import static mysql.InsertHelper.getInsert;
import static mysql.SelectHelper.getSelect;

@Listeners(Listener.class)
public class Lecture_19 {

    @Test(priority = 1)
    public void selectTest() {
        getSelect().select("*").from("user").getListData().forEach(System.out::println);
    }

    @Test(priority = 2)
    public void inputTest() {
        getInsert().table("user").into("id").values("1").execute();
    }

}

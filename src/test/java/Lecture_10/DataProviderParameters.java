package Lecture_10;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderParameters {

    @DataProvider(name = "Входящие данные для задачки iTechArt")
    public Object[][] inputForITechTask() {
        return new Object[][]{
                {3, "iTech"},
                {5, "Art"},
                {15, "iTechArt"},
                {6, "iTech"},
                {10, "Art"},
                {30, "iTechArt"},
                {1, "Говно, переделывай"},
                {-1, "Говно, переделывай"},
                {1000000000, "Art"},
                {3.3, "Говно, переделывай"}
        };
    }

    @Test(dataProvider = "Входящие данные для задачки iTechArt", threadPoolSize = 5, enabled = false)
    public void test1(double number, String expectedString) {
        System.out.println(number + " " + expectedString);
    }

    @Parameters({"login"})
    @Test()
    public void test2(@Optional("name") String login) {
        System.out.println(login);
    }
}

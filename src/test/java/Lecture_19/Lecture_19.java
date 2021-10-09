package Lecture_19;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static mysql.DeleteHelper.getDelete;
import static mysql.InputHelper.getInput;
import static mysql.SelectHelper.getSelect;
import static mysql.UpdatedHelper.getUpdate;

public class Lecture_19 {

    @Test(dataProvider = "data")
    public void selectTest(String id) {
        Assert.assertEquals(getSelect().select("*").from("user").where("id=" + id).execute().getListData().get(0).get(0), id);
        Assert.assertEquals(getSelect().select("*").from("user").where("id=" + id).execute().getMapData().get("id").get(0), id);
    }

    @DataProvider(name = "data", parallel = true)
    private Object[][] getData() {
        return new Object[][]{
                {"1"},
                {"2"},
                {"3"},
                {"4"},
        };
    }

    @Test(priority = 2)
    public void insertTest() {
        getInput().table("user").into("id, first_name").values("33, 'Data'").execute();
        Assert.assertEquals(getSelect().select("*").from("user").where("id=33").execute().getListData().get(0).get(0), "33");
    }

    @Test(priority = 3)
    public void updateTest() {
        getUpdate().table("user").set("first_name='Data 1'").where("id=33").execute();
        Assert.assertEquals(getSelect().select("*").from("user").where("id=33").execute().getMapData().get("first_name").get(0), "Data 1");
    }

    @Test(priority = 4)
    public void deleteTest() {
        getDelete().from("user").where("id=33").execute();
        Assert.assertTrue(getSelect().select("*").from("user").where("id=33").execute().getListData().isEmpty());
    }
}

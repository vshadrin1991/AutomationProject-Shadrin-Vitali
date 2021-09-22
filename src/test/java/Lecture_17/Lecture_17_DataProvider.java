package Lecture_17;

import Lecture_17.user.Root;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

@Log4j2
public class Lecture_17_DataProvider {

    @BeforeTest
    public void preconditions() {
        baseURI = "https://reqres.in";
    }

    @Test(dataProvider = "data")
    public void test(Response response, int expectedData) {
        Assert.assertEquals(response.as(Root.class).data.id, expectedData);
    }

    @DataProvider(parallel = true)
    public Object[][] data() {
        return new Object[][]{
                {given().when().header("Content-type", "application/json").and().get("/api/users?id=1").then().extract().response(), 1},
                {given().when().header("Content-type", "application/json").and().get("/api/users?id=2").then().extract().response(), 2},
                {given().when().header("Content-type", "application/json").and().get("/api/users?id=3").then().extract().response(), 3},
                {given().when().header("Content-type", "application/json").and().get("/api/users?id=4").then().extract().response(), 4},
                {given().when().header("Content-type", "application/json").and().get("/api/users?id=5").then().extract().response(), 5},
        };
    }
}

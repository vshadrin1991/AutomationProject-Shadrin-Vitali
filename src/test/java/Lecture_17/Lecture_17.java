package Lecture_17;

import Lecture_17.User.Root;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Lecture_17 {

    @BeforeTest
    public void preconditions() {
        baseURI = "https://reqres.in";
    }

    @Test(dataProvider = "data")
    public void test1(int integer) {
        String endpoint = "/api/users?id=" + integer;
        Gson gson = new Gson();
        Root root = gson.fromJson(given().when().get(endpoint).getBody().asPrettyString(), Root.class);
        Assert.assertEquals(root.data.id, integer);
    }

    @Test
    public void test2() {
        String endpoint = "/api/users?id=6";
        Root root = given().when().get(endpoint).as(Root.class);
        Assert.assertEquals(root.data.id, 6);
    }

    @Test
    public void test3() {
        String endpoint = "/api/users?id=7";
        given().when().get(endpoint).then().statusCode(HttpStatus.SC_OK);
        given().when().get(endpoint).then().statusCode(200);
    }

    @Test
    public void test4() {
        String endpoint = "/api/users";
        Assert.assertEquals(given().when().param("id", "8").get(endpoint).as(Root.class).data.id, 8);
    }

    @Test
    public void test5() {
        String endpoint = "/api/users";
        String requestBody = readFileAsString("post");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.jsonPath().get("job"), "leader");
    }

    @Test
    public void test6() {
        String endpoint = "/api/users";
        String requestBody = readFileAsString("put");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().put(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("job"), "zion resident");
    }

    @Test
    public void test7() {
        String endpoint = "/api/users";
        String requestBody = readFileAsString("patch");
        Response response = given().header("Content-Type", "application/json").and().body(requestBody).and().patch(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("job"), "zion resident1");
    }

    @Test
    public void test8() {
        String endpoint = "/api/users/2";
        Response response = given().delete(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 204);
    }

    @DataProvider(parallel = true)
    public Object[][] data() {
        return new Object[][]{
                {1},
                {2},
                {3},
                {4},
                {5}
        };
    }

    public static String readFileAsString(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/Lecture_17/requests/" + fileName + ".json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}

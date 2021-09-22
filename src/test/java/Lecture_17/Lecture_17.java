package Lecture_17;


import Lecture_17.user.Root;
import com.google.gson.Gson;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

@Log4j2
public class Lecture_17 {

    @BeforeTest
    public void preconditions() {
        baseURI = "https://reqres.in";
    }

    @Test
    public void test1() {
        String endpoint = "/api/users?id=1";
        Gson gson = new Gson();
        Root root = gson.fromJson(given().when().get(endpoint).getBody().asPrettyString(), Root.class);
        Assert.assertEquals(root.data.id, 1);
    }

    @Test
    public void test2() {
        String endpoint = "/api/users?id=2";
        Root root = given().when().get(endpoint).as(Root.class);
        Assert.assertEquals(root.data.id, 2);
    }

    @Test
    public void test3() {
        String endpoint = "/api/users?id=3";
        given().when().header("Content-type", "application/json").and().get(endpoint).then().statusCode(HttpStatus.SC_OK);
        given().when().get(endpoint).then().log().body().statusCode(200);
    }

    @Test
    public void test4() {
        String endpoint = "/api/users";
        Root root = given().header("Content-type", "application/json").and().param("id", "4").get(endpoint).as(Root.class);
        Assert.assertEquals(root.data.id, 4);
    }

    @Test
    public void test5() {
        String endpoint = "/api/users";
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response response = given().header("Content-type", "application/json").and().body(requestBody).and().post(endpoint).then().extract().response();
        Assert.assertEquals(201, response.statusCode());
        Assert.assertEquals(response.jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.jsonPath().get("job"), "leader");
    }

    @Test
    public void test6() {
        String endpoint = "/api/users";
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        Response response = given().header("Content-type", "application/json").and().body(requestBody).and().put(endpoint).then().extract().response();
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(response.jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.jsonPath().get("job"), "zion resident");
    }


    @Test
    public void test7() {
        String endpoint = "/api/users";
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        Response response = given().header("Content-type", "application/json").and().body(requestBody).and().patch(endpoint).then().extract().response();
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(response.jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.jsonPath().get("job"), "zion resident");
    }

    @Test
    public void test8() {
        String endpoint = "/api/users/2";
        Response response = given().header("Content-type", "application/json").delete(endpoint).then().extract().response();
        Assert.assertEquals(204, response.statusCode());
    }

}

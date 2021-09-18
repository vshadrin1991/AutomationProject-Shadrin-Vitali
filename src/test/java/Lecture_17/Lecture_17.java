package Lecture_17;

import Lecture_17.user.Items;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class Lecture_17 {

    @Test
    public void test() {
        RestAssured.baseURI = "https://api.hh.ru";
        String endpoint = "/vacancies?text=QA";
        Gson gson = new Gson();


        Items items = gson.fromJson(RestAssured.given().request(Method.GET, endpoint).getBody().print(), Items.class);
        log.info(items.getUserItem().get(0).id);
    }
}

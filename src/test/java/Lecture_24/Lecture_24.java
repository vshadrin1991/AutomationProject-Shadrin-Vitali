package Lecture_24;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class Lecture_24 {
    String token;
    Gson gson = new Gson();
    ObjectMapper mapper = new ObjectMapper();
    Login login = new Login() {{
        setLogin("qa07qa@mail.ru");
        setPassword("qa07qa07");
    }};

    @BeforeTest
    public void preconditions() throws JsonProcessingException {
        baseURI = "https://www.onliner.by";
        String response = given().when().body(mapper.writeValueAsString(login))
                .and().header("Content-Type", "application/json").when().post("/sdapi/user.api/login").getBody().asPrettyString();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        token = jsonObject.get("access_token").getAsString();
    }

    @Test()
    public void test() {
        baseURI = "https://cart.onliner.by";
        given().when().header("Authorization", "Bearer " + token).and().header("Content-Type", "application/json").get("/sdapi/cart.api/orders").prettyPrint();
    }
}

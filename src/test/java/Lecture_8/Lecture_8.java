package Lecture_8;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import driver.DriverExecutor;
import jsonPojo.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class Lecture_8 extends DriverExecutor {

    @Test
    public void test1() throws Exception {
        Gson gson = new Gson();
        String json = readFileAsString();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("orderID"));
        System.out.println(jsonObject.get("contents").getAsJsonArray().get(0).getAsJsonObject().get("productID"));
        System.out.println(jsonObject.get("contents").getAsJsonArray().get(1).getAsJsonObject().get("productID"));
    }

    @Test
    public void test2() throws Exception {
        Gson gson = new Gson();
        String json = readFileAsString();
        User user = gson.fromJson(json, User.class);
        System.out.println(user);
        System.out.println(user.getOrderID());
        System.out.println(user.getContents().get(0).getProductID());
        System.out.println(user.getContents().get(1).getProductID());
    }

    @Test
    public void test3() throws Exception {
        Gson gson = new Gson();
        String json = readFileAsString();
        User user = gson.fromJson(json, User.class);
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        assertEquals(user.getOrderID().doubleValue(), jsonObject.get("orderID").getAsDouble());
    }

    @Test
    public void test4() {
        driver.get(System.getProperty("user.dir") + "/src/test/java/Lecture_8/html/table.html");
        List<WebElement> headers = driver.findElements(By.xpath("//table//th"));
        Map<String, List<String>> data = new HashMap<>() {{
            for (int i = 0; i < headers.size(); i++) {
                List<WebElement> columns = driver.findElements(By.xpath("//table//tr//following::tr/td[" + (i + 1) + "]"));
                put(headers.get(i).getText(), columns.stream().map(data -> data.getText()).collect(Collectors.toList()));
            }
        }};
        data.forEach((k, v) -> System.out.println(k + " --> " + v));
    }

    public static String readFileAsString() throws Exception {
        return new String(Files.readAllBytes(Paths.get("src/test/java/Lecture_8/data.json")));
    }
}

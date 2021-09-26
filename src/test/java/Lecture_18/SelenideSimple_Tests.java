package Lecture_18;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSimple_Tests {

    @Test
    public void test1() {
        open("https://moodpanda.com/");
        $(By.id("page-top")).shouldBe(exist);
        $(".scroll-down > .btn.page-scroll ").click();
        List<String> data = $("#bs-example-navbar-collapse-1").findAll(byXpath("ul//li//a")).stream().map(el -> el.getText()).collect(Collectors.toList());
        System.out.println(data);
    }

    @Test
    public void test2() {
        $("#bs-example-navbar-collapse-1").findAll(By.xpath("ul//li//a")).find(text("Login")).click();
    }

    @AfterTest
    public void post() {
        closeWebDriver();
    }
}

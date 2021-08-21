package Lecture_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lecture_5 {
    WebDriver driver = null;

    @BeforeTest
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Открыть сайт https://calc.by/weight-and-calories/body-mass-index-calculator.html
     * Ввести Рост = 183 см
     * Ввести Вес = 58 кг
     * Нажать на кнопку ‘Рассчитать’
     * Проверить, что значение в поле ‘ИМТ’ равно 17.32
     * Проверить, что статус равен ’ Недостаточной массе тела’
     * Закрыть окно браузера
     */
    @Test(priority = 1)
    public void test1() {
        driver.get("https://calc.by/weight-and-calories/body-mass-index-calculator.html");
        WebElement growth = driver.findElement(By.id("bmiVar1"));
        WebElement weigth = driver.findElement(By.id("bmiVar2"));
        WebElement calcBtn = driver.findElement(By.xpath("//*[@class='calc-btn btn-calculate']"));
        growth.sendKeys("183");
        weigth.sendKeys("58");
        calcBtn.click();
        Assert.assertEquals(driver.findElement(By.id("AnswerBMI")).getText(), "17.32");
        Assert.assertEquals(driver.findElement(By.id("AnswerBMI1")).getText(), "Недостаточной массе тела");
    }

    /**
     * Открыть сайт https://calc.by/building-calculators/laminate.html
     * Выбрать ‘Способ укладки ламината’ из выпадающего списка
     * Ввести ‘Длина комнаты’ = 500
     * Ввести ‘Ширина комнаты’ = 400
     * Ввести ‘Длина панели ламината’ = 2000
     * Ввести ‘Ширина панели ламината’ = 200
     * Выбрать ’Направление укладки’ = по ширине комнаты
     * Нажать на кнопку ‘Рассчитать’
     * Проверить результаты: ‘Требуемое количество досок ламината: 53’
     * Проверить результаты: ‘Количество упаковок ламината: 7’
     * Закрыть окно браузера
     */
    @Test(priority = 2)
    public void test2() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");
        Select select = new Select(driver.findElement(By.id("laying_method_laminate")));
        select.selectByIndex(2);
        enter("ln_room_id", "500");
        enter("wd_room_id", "400");
        enter("ln_lam_id", "2000");
        enter("wd_lam_id", "200");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@class='calc-btn']"))).perform();
        driver.findElement(By.id("direction-laminate-id1")).click();
        driver.findElement(By.xpath("//*[@class='calc-btn']")).click();

        Thread.sleep(2000);
        List<String> textList = new ArrayList<>();
        driver.findElements(By.xpath("//*[@class='calc-result']//div")).forEach(data -> textList.add(data.getText()));
        Assert.assertTrue(textList.contains("Требуемое количество досок ламината: 53"));
        Assert.assertTrue(textList.contains("Количество упаковок ламината: 7"));

    }

    @AfterTest
    public void postconditions() {
        driver.quit();
    }

    /**
     * @param element - locator
     * @param data    - type text
     */
    public void enter(String element, String data) {
        driver.findElement(By.id(element)).clear();
        driver.findElement(By.id(element)).sendKeys(data);
    }
}

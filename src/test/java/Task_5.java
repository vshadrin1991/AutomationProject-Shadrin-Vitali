import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Task_5 {
    private static WebDriver driver;

    @BeforeTest
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "dataProvider")
    public void test_1(HashMap<String, Integer> dataProvider, List<String> expectedData) {
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        dataProvider.forEach((key, value) -> {
            if (!key.equals("select_index")) {
                enter(key, value);
            } else {
                select().selectByIndex(value);
            }
        });
        calculate();
        Assert.assertEquals(expectedData, getCalculateData());
    }

    @Test
    public void test3() {
        String l = "1,2,3,0,-1,10,11,-20,40";
        List<Integer> list = new ArrayList<>() {{
            addAll(Arrays.stream(l.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
        }};
        System.out.println(list.stream().filter(d -> d > 0).collect(Collectors.toList()));
        System.out.println(list.stream().filter(d -> d < 0).collect(Collectors.toList()));
        System.out.println(list.stream().filter(d -> d % 5 == 0).collect(Collectors.toList()));
        System.out.println(list.stream().filter(d -> d % 10 == 0).collect(Collectors.toList()));
    }

    @DataProvider
    private Object[][] dataProvider() {
        return new Object[][]{
                {
                        new HashMap<String, Integer>() {{
                            put("calc_roomwidth", 1);
                            put("calc_roomheight", 2);
                            put("calc_lamwidth", 103);
                            put("calc_lamheight", 104);
                            put("calc_inpack", 5);
                            put("calc_price", 60);
                            put("calc_bias", 7);
                            put("calc_walldist", 8);
                            put("select_index", 1);
                        }},
                        Arrays.asList("РЕЗУЛЬТАТ РАСЧЕТА:", "Площадь укладки: 1.95 м2.", "Кол-во панелей: 200 шт.", "Кол-во упаковок: 40 шт.", "Стоимость: 128 руб.", "Остатки: 0 шт.", "Отрезки: 8 шт.")
                },
                {
                        new HashMap<String, Integer>() {{
                            put("calc_roomwidth", 2);
                            put("calc_roomheight", 3);
                            put("calc_lamwidth", 104);
                            put("calc_lamheight", 105);
                            put("calc_inpack", 6);
                            put("calc_price", 70);
                            put("calc_bias", 8);
                            put("calc_walldist", 9);
                            put("select_index", 0);
                        }},
                        Arrays.asList("РЕЗУЛЬТАТ РАСЧЕТА:", "Площадь укладки: 5.91 м2.", "Кол-во панелей: 580 шт.", "Кол-во упаковок: 97 шт.", "Стоимость: 444 руб.", "Остатки: 2 шт.", "Отрезки: 27 шт.")
                },
                {
                        new HashMap<String, Integer>() {{
                            put("calc_roomwidth", 3);
                            put("calc_roomheight", 4);
                            put("calc_lamwidth", 105);
                            put("calc_lamheight", 106);
                            put("calc_inpack", 7);
                            put("calc_price", 80);
                            put("calc_bias", 9);
                            put("calc_walldist", 10);
                            put("select_index", 1);
                        }},
                        Arrays.asList("РЕЗУЛЬТАТ РАСЧЕТА:", "Площадь укладки: 11.86 м2.", "Кол-во панелей: 1102 шт.", "Кол-во упаковок: 158 шт.", "Стоимость: 984 руб.", "Остатки: 4 шт.", "Отрезки: 27 шт.")
                },
        };
    }


    /**
     * @param element - input locator
     * @param value   - enter value
     */
    private void enter(String element, Integer value) {
        driver.findElement(By.name(element)).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), value.toString(), Keys.ENTER);
    }

    /**
     * click calculate button
     */
    private void calculate() {
        driver.findElement(By.cssSelector("div[class='form_element']>input")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return selector
     */

    private Select select() {
        return new Select(driver.findElement(By.name("calc_direct")));
    }

    /**
     * @return list with calculate data
     */
    private List<String> getCalculateData() {
        return driver.findElements(By.cssSelector("div[class*='whiteback']>div")).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @AfterTest
    public void postconditions() {
        driver.quit();
    }
}

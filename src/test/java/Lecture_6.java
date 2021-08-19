import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lecture_6 {

    WebDriver driver = null;

    @BeforeTest
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.cssSelector("input.submit-button.btn_action")).click();
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.tagName("h3")).isDisplayed(), true);
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.tagName("h3")).isDisplayed(), true);
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
    }

    @AfterTest
    public void postconditions() {
        driver.quit();
    }

}

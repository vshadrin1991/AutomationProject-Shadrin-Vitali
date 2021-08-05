import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest {

    @Test
    public void test1() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.google.by/");
        driver.findElement(By.name("q")).sendKeys("Hello world", Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Hello, world! Карта для тех, кто летает | МТБанк");
        driver.quit();
    }
}

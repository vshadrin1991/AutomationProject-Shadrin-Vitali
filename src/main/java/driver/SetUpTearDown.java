package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class SetUpTearDown implements ITestListener {
    public static WebDriver driver;

    @Override
    public void onStart(ITestContext context) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Override
    public void onFinish(ITestContext context) {
        driver.quit();
    }

}

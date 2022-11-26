package Common;

import Locators.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    @BeforeMethod
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30L));
    }


    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}

package BT1;

import Common.BaseTest;
import Locators.Category;
import Locators.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddCategory_Ifelse extends BaseTest {
    public static String categoryName = "Test-Nhung2";

    @BeforeMethod
    public void Login() {
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        driver.findElement(By.xpath(Login.Click_Copy)).click();
        driver.findElement(By.xpath(Login.Click_Login)).click();
    }

    @Test
    public void addCategory() throws InterruptedException {
        driver.findElement(By.xpath(Category.Click_Products)).click();
        driver.findElement(By.xpath(Category.Click_Category)).click();
        driver.findElement(By.xpath(Category.Click_AddNewCategory)).click();
        driver.findElement(By.xpath(Category.Input_Name)).sendKeys(categoryName);
        driver.findElement(By.xpath(Category.Click_ParentCategory)).click();
        driver.findElement(By.xpath(Category.Input_ParentCategory)).sendKeys("Women shoe");
        driver.findElement(By.xpath(Category.Select_ParentCategory)).click();
        driver.findElement(By.xpath(Category.Input_OrderNumber)).sendKeys("10");
        driver.findElement(By.xpath(Category.Click_Type)).click();
        Category.Select_Type("Physical");
        driver.findElement(By.xpath(Category.Click_Banner)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Category.Input_Banner)).sendKeys("banner-01-02", Keys.ENTER);
        Thread.sleep(6000);
        driver.findElement(By.xpath(Category.Click_BannerOption)).click();
        driver.findElement(By.xpath(Category.Click_AddBanner)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Category.Click_Icon)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Category.Input_Icon)).sendKeys("S128");
        Thread.sleep(4000);
        driver.findElement(By.xpath(Category.Click_IconOption)).click();
        driver.findElement(By.xpath(Category.Click_AddIcon)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Category.Input_MetalTitle)).sendKeys("shoe 01");
        driver.findElement(By.xpath(Category.Input_MetalDescription)).sendKeys("shoe in medium price");
        driver.findElement(By.xpath(Category.Click_FilteringATB)).click();
        driver.findElement(By.xpath(Category.Input_FilteringATB)).sendKeys("Fabric");
        driver.findElement(By.xpath(Category.Select_FilteringATB)).click();
        driver.findElement(By.xpath(Category.Click_Save)).click();
        Thread.sleep(4000);
    }

    @Test
    public void searchNewCategory() throws InterruptedException {
        driver.findElement(By.xpath(Category.Click_Products)).click();
        driver.findElement(By.xpath(Category.Click_Category)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Category.Input_SearchCategory)).sendKeys(categoryName, Keys.ENTER);
        Thread.sleep(2000);
        // So sánh kết quả add Category
        WebElement categoryElement = driver.findElement(By.xpath(Category.categorySearchResult));
        String categoryValue = categoryElement.getText();
        // dùng If
        if (categoryValue.equals(categoryName)) {
            System.out.println("add category successfully!");
        } else {
            System.out.println("add category failed!");
        }

    }


}

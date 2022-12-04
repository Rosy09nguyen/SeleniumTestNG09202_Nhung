package Homework;

import Common.BaseTest;
import Helper.Keywords;
import Locators.Category;
import Locators.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;

public class Edit_Remove_Category extends BaseTest {

    @BeforeMethod
    public void Login() {
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        driver.findElement(By.xpath(Login.Click_Copy)).click();
        driver.findElement(By.xpath(Login.Click_Login)).click();
        Keywords.sleep(3);
    }

    @Test
    public void editCategory() {
        String categoryNameOriginal = "Test Nhung";
        String categoryNameEdit = "Test Nhung 1";

        driver.findElement(By.xpath(Category.Click_Products)).click();
        driver.findElement(By.xpath(Category.Click_Category)).click();
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Input_SearchCategory)).sendKeys(categoryNameOriginal, Keys.ENTER);
        Keywords.sleep(2);
        WebElement categoryElement = driver.findElement(By.xpath(Category.categorySearchResult));
        String categorySearchValue = categoryElement.getText();
        // dùng Assert tìm giá trị
        Assert.assertEquals(categorySearchValue, categoryNameOriginal, "can not find the add category");
        driver.findElement(By.xpath(Category.categoryButton_Edit)).click();
        Keywords.sleep(1);

        // edit giá trị vừa tìm
        driver.findElement(By.xpath(Category.Input_Name)).clear();
        driver.findElement(By.xpath(Category.Input_Name)).sendKeys(categoryNameEdit);
        Keywords.sleep(1);
        driver.findElement(By.xpath(Category.Click_ParentCategory)).click();
        driver.findElement(By.xpath(Category.Input_ParentCategory)).sendKeys("Luxury car");
        driver.findElement(By.xpath(Category.Select_ParentCategory)).click();
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Input_OrderNumber)).clear();
        driver.findElement(By.xpath(Category.Input_OrderNumber)).sendKeys("15");
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Click_Type)).click();
        Category.Select_Type("Physical");
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Click_Banner)).click();
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Input_Banner)).sendKeys("Group 22446", Keys.ENTER);
        Keywords.sleep(15);
        driver.findElement(By.xpath(Category.Click_BannerOption)).click();
        driver.findElement(By.xpath(Category.Click_AddBanner)).click();
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Click_Icon)).click();
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Input_Icon)).sendKeys("Nissan", Keys.ENTER);
        Keywords.sleep(15);
        driver.findElement(By.xpath(Category.Click_IconOption)).click();
        driver.findElement(By.xpath(Category.Click_AddIcon)).click();
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Input_MetalTitle)).clear();
        driver.findElement(By.xpath(Category.Input_MetalTitle)).sendKeys("Nissan 01");
        Keywords.sleep(1);
        driver.findElement(By.xpath(Category.Input_MetalDescription)).clear();
        driver.findElement(By.xpath(Category.Input_MetalDescription)).sendKeys("car in luxury price");
        Keywords.sleep(1);
        driver.findElement(By.xpath(Category.Input_Slug)).clear();
        driver.findElement(By.xpath(Category.Input_Slug)).sendKeys("luxury car");
        Keywords.sleep(1);
        driver.findElement(By.xpath(Category.Click_FilteringATB)).click();
        driver.findElement(By.xpath(Category.Input_FilteringATB)).sendKeys("Wheel");
        driver.findElement(By.xpath(Category.Select_FilteringATB)).click();
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Click_Save)).click();
        Keywords.sleep(4);
        driver.findElement(By.xpath(Category.Click_Category)).click();
        Keywords.sleep(2);
        // dùng Assert so sánh lại giá trị sau edit
        driver.findElement(By.xpath(Category.Input_SearchCategory)).sendKeys(categoryNameEdit, Keys.ENTER);
        Keywords.sleep(2);
        Assert.assertTrue(categorySearchValue.equals(categoryNameEdit), "edit category failed!");
        System.out.println("edit category to" + categorySearchValue + "successfully!");
    }

    @Test
    public void removeCategory() {
        String categoryName = "exercise 5";

        driver.findElement(By.xpath(Category.Click_Products)).click();
        driver.findElement(By.xpath(Category.Click_Category)).click();
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Input_SearchCategory)).sendKeys(categoryName, Keys.ENTER);
        Keywords.sleep(2);
        WebElement categoryElement = driver.findElement(By.xpath(Category.categorySearchResult));
        String categorySearchValue = categoryElement.getText();
        // dùng Assert tìm giá trị
        Assert.assertEquals(categorySearchValue, categoryName, "can not find the add category");
        driver.findElement(By.xpath(Category.categoryButton_Delete)).click();
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.deleteConfirm_DeleteButton)).click();
        Keywords.sleep(3);
        driver.findElement(By.xpath(Category.Input_SearchCategory)).sendKeys(categoryName, Keys.ENTER);
        Keywords.sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(Category.categorySearchEmpty)).isDisplayed(), "delete category failed!");
        System.out.println("delete category to " + categoryName + " successfully!");

    }

}

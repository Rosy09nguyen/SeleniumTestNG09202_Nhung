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
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;


public class AddCategory_Assert extends BaseTest {
    public static String categoryName = "Test Nhung";
    SoftAssert softassert = new SoftAssert();

    @BeforeMethod
    public void Login() {
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        driver.findElement(By.xpath(Login.Click_Copy)).click();
        driver.findElement(By.xpath(Login.Click_Login)).click();
        Keywords.sleep(3);
    }

    @Test
    public void addCategory() {

        driver.findElement(By.xpath(Category.Click_Products)).click();
        driver.findElement(By.xpath(Category.Click_Category)).click();
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Click_AddNewCategory)).click();

        System.out.println("So sánh tên Header và Label Text Box trong form");

        String LabelHeader_Actual = driver.findElement(By.xpath(Category.LabelHeader_AddCategory)).getText();
        String LabelHeader_Expected = "Category Information";
        softassert.assertTrue(LabelHeader_Actual.equals(LabelHeader_Expected), "sai tên header form");

        List<WebElement> Label_InputTextbox = new ArrayList<>();
        Label_InputTextbox = driver.findElements(By.xpath(Category.Label_AddCategoryForm));
        List<String> LabelActual_InputTextboxes = new ArrayList<>();
        for (int index = 0; index < Label_InputTextbox.size(); index++) {
            LabelActual_InputTextboxes.add(Label_InputTextbox.get(index).getText());
        }
        List<String> LabelExpected_InputTextBoxes = new ArrayList<>();
        LabelExpected_InputTextBoxes.add("Name");
        LabelExpected_InputTextBoxes.add("Parent Category");
        LabelExpected_InputTextBoxes.add("Ordering Number");
        LabelExpected_InputTextBoxes.add("Type");
        LabelExpected_InputTextBoxes.add("Banner");
        LabelExpected_InputTextBoxes.add("Icon");
        LabelExpected_InputTextBoxes.add("Meta Title");
        LabelExpected_InputTextBoxes.add("Meta Description");
        LabelExpected_InputTextBoxes.add("Filtering Attributes");

        for (int index = 0; index < Label_InputTextbox.size(); index++) {
            softassert.assertEquals(LabelActual_InputTextboxes.get(index), LabelExpected_InputTextBoxes.get(index), "sai tên text box " + LabelExpected_InputTextBoxes.get(index));
        }

        driver.findElement(By.xpath(Category.Input_Name)).sendKeys(categoryName);
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Click_ParentCategory)).click();
        driver.findElement(By.xpath(Category.Input_ParentCategory)).sendKeys("Women shoe");
        driver.findElement(By.xpath(Category.Select_ParentCategory)).click();
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Input_OrderNumber)).sendKeys("10");
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Click_Type)).click();
        Category.Select_Type("Digital");
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Click_Banner)).click();
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Input_Banner)).sendKeys("banner-01-02", Keys.ENTER);
        Keywords.sleep(10);
        driver.findElement(By.xpath(Category.Click_BannerOption)).click();
        driver.findElement(By.xpath(Category.Click_AddBanner)).click();
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Click_Icon)).click();
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Input_Icon)).sendKeys("T-29",Keys.ENTER);
        Keywords.sleep(4);
        driver.findElement(By.xpath(Category.Click_IconOption)).click();
        driver.findElement(By.xpath(Category.Click_AddIcon)).click();
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Input_MetalTitle)).sendKeys("shoe 01");
        driver.findElement(By.xpath(Category.Input_MetalDescription)).sendKeys("shoe in medium price");
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Click_FilteringATB)).click();
        driver.findElement(By.xpath(Category.Input_FilteringATB)).sendKeys("Size");
        driver.findElement(By.xpath(Category.Select_FilteringATB)).click();
        Keywords.sleep(2);
        driver.findElement(By.xpath(Category.Click_Save)).click();
        Keywords.sleep(4);
        softassert.assertAll();
    }

    @Test
    public void searchNewCategory(){
        driver.findElement(By.xpath(Category.Click_Products)).click();
        driver.findElement(By.xpath(Category.Click_Category)).click();
        Keywords.sleep(2);
        System.out.println("Kiểm tra label Category Overview");
        String Header_CategoryOverview_Actual = driver.findElement(By.xpath(Category.LabelHeader_CategoryOverview)).getText();
        softassert.assertEquals(Header_CategoryOverview_Actual, "All Categories", "sai tên Trang Category");
        String Header_CategoriesTable_Actual = driver.findElement(By.xpath(Category.LabelHeader_CategoriesTable)).getText();
        softassert.assertEquals(Header_CategoriesTable_Actual, "Categories", "sai tên Bảng Category");
        String Column_Name_Actual = driver.findElement(By.xpath(Category.LabelColumn_Name)).getText();
        softassert.assertEquals(Column_Name_Actual, "Name", "sai tên cột tên Category");
        String Column_Options_Actual = driver.findElement(By.xpath(Category.LabelColumn_Options)).getText();
        softassert.assertEquals(Column_Options_Actual, "Options", "sai tên cột tác vụ");

        driver.findElement(By.xpath(Category.Input_SearchCategory)).sendKeys(categoryName, Keys.ENTER);
        Keywords.sleep(2);
        // So sánh kết quả add Category
        WebElement categoryElement = driver.findElement(By.xpath(Category.categorySearchResult));
        String categoryValue = categoryElement.getText();
        // dùng Assert
        Assert.assertEquals(categoryValue, categoryName, "add category failed!");
        System.out.println("add category successfully!");
        softassert.assertAll();

    }

}

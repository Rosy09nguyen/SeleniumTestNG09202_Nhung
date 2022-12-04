package Locators;

import Common.BaseTest;
import org.openqa.selenium.By;

public class Category {
    public static String Click_Products = "//span[normalize-space()='Products']";
    public static String Click_Category = "//span[normalize-space()='Category']";
    public static String Click_AddNewCategory = "//span[normalize-space()='Add New category']";

    // Xpath elements of Add new Category
    public static String LabelHeader_AddCategory = "//div[@class='card']//h5";

    public static String Label_AddCategoryForm = "//div[@class='card-body']//label";
    //Name text box
    public static String Input_Name = "//input[@id='name']";
    //ParentCategory Combobox
    public static String Click_ParentCategory = "//div[@class='dropdown bootstrap-select select2 form-control aiz-']";
    public static String Input_ParentCategory = "//div[@class='dropdown-menu show']//input";
    public static String Select_ParentCategory = "//div[@class='dropdown-menu show']//li[@class='active']";
    //OrderNumber Textbox
    public static String Input_OrderNumber = "//input[@id='order_level']";
    //Type Combobox
    public static String Click_Type = "//label[normalize-space()='Type']/following-sibling::div//div[1]";

    public static void Select_Type(String typeOption) {
        BaseTest.driver.findElement(By.xpath("//span[normalize-space()='" + typeOption + "']")).click();
    }

    //Banner
    public static String Click_Banner = "(//div[contains(text(),'Browse')])[1]";
    public static String Input_Banner = "//div[@class='aiz-uploader-search text-right']//input";
    public static String Click_BannerOption = "(//div[@class='aiz-file-box'])[1]";
    public static String Click_AddBanner = "//button[normalize-space()='Add Files']";
    //icon
    public static String Click_Icon = "(//div[contains(text(), 'Browse')])[2]";
    public static String Input_Icon = "//div[@class='aiz-uploader-search text-right']//input";
    public static String Click_IconOption = "(//div[@class='card-file-thumb'])[1]";
    public static String Click_AddIcon = "//button[normalize-space()='Add Files']";
    //Meta title
    public static String Input_MetalTitle = "//input[@name='meta_title']";
    //Slug
    public static String Input_Slug = "//input[@id='slug']";
    //Meta Description
    public static String Input_MetalDescription = "//textarea[@name='meta_description']";
    //FilteringATB
    public static String Click_FilteringATB = "//label[normalize-space()='Filtering Attributes']/following-sibling::div//button";
    public static String Input_FilteringATB = "//div[@class='dropdown-menu show']//input";
    public static String Select_FilteringATB = "//div[@class='dropdown-menu show']//li[@class='active']";
    public static String Click_Save = "//button[normalize-space()='Save']";
    //Category List page
    public static String LabelHeader_CategoryOverview = "//div[@class='aiz-main-content']//h1";
    public static String LabelHeader_CategoriesTable = "//div[@class='card']//h5";
    public static String LabelColumn_Name = "//tr[@class='footable-header']//th[@class='footable-first-visible']";
    public static String LabelColumn_Options = "//tr[@class='footable-header']//th[@class='text-right footable-last-visible']";
    public static String Input_SearchCategory = "//input[@id='search']";
    public static String categorySearchResult = "//table[@class='table aiz-table mb-0 footable footable-1 breakpoint breakpoint-lg']//td[1]/following-sibling::td[1]";
    public static String categoryButton_Edit = "//a[@title='Edit']";

    public static String categoryButton_Delete = "(//a[@title='Delete'])";
    // delete popup
    //h4[normalize-space()='Delete Confirmation']
    public static String deleteConfirm_DeleteButton = "//a[@id='delete-link']";
    // table result empty
//    public static String categorySearchEmpty = "//table[@class='table aiz-table mb-0 footable footable-1 breakpoint breakpoint-lg']//td";
    public static String categorySearchEmpty =" //td[normalize-space()='Nothing found']";

}


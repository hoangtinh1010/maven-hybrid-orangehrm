package ui.jquery;


import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.jquery.HomePageObject;
import pageObjects.openCart.admin.AdminCustomerPO;
import pageObjects.openCart.admin.AdminDashboardPO;
import pageObjects.openCart.admin.AdminLoginPO;
import pageObjects.openCart.user.UserHomePO;
import pageObjects.openCart.user.UserLoginPO;
import pageObjects.openCart.user.UserMyAccountPO;
import pageObjects.openCart.user.UserRegisterPO;

import java.util.List;


public class Level_12_DataTable extends BaseTest {

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getPage(HomePageObject.class, driver);

    }


    @Test(enabled = false)
    public void Table_01_Paging() {
        // 1 - Mở ra 1 trang bất kỳ dựa vào số trang truyền vào
        homePage.openPageByNumber("10");
        Assert.assertTrue(homePage.isPageActivedByNumber("10"));

        homePage.openPageByNumber("15");
        Assert.assertTrue(homePage.isPageActivedByNumber("15"));
        homePage.refreshPage(driver);

    }

    @Test(enabled = false)
    public void Table_02_Search() {
        // 2 - Search ở bất kỳ 1 header textbox nào dựa vào tên cột
        homePage.enterToHeaderTextboxByName("Country", "Argentina");
        homePage.sleepInSecond(2);

        // 3- Verify bất kỳ thông tin của 1 Country nào (Male, Country, Femaile, Total)
        Assert.assertTrue(homePage.isRowValueDisplayed("338282", "Argentina", "349238", "687522"));
        //refresh trang
        homePage.refreshPage(driver);

        homePage.enterToHeaderTextboxByName("Females", "276880");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isRowValueDisplayed("276880", "Angola", "276472", "553353"));
        homePage.refreshPage(driver);

        homePage.enterToHeaderTextboxByName("Males", "803");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isRowValueDisplayed("777", "Antigua and Barbuda", "803", "1580"));
        homePage.refreshPage(driver);
    }

    @Test(enabled = false)
    public void Table_03_Action() {
        // 4 - Có thể Xóa/Edit bất kỳ country nào dựa vào tên Country
        homePage.clickToActionByCountryName("Afghanistan", "remove");
        homePage.sleepInSecond(2);
        homePage.refreshPage(driver);

        homePage.enterToHeaderTextboxByName("Country", "Argentina");
        homePage.sleepInSecond(2);
        homePage.clickToActionByCountryName("Argentina", "edit");
    }

    @Test(enabled = false)
    public void Table_04_Index() {
        // 5 - Verify dữ liệu của 1 row bất kỳ dựa vào vị trí index (số thứ tự)
        // 6 - Kết hợp tất cả các chức năng (Paging, Search, Edit/Add/Delete, Verify)
        homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        homePage.clickLoadDataButton();
        homePage.enterToTextboxByColumnNameAndRowIndex("Company", "3", "ABC Company");
        homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person", "3", "John Smith");
        homePage.enterToTextboxByColumnNameAndRowIndex("Order Placed", "3", "1");
        homePage.selectToDropdownByColumnNameAndRowIndex("Country", "3", "Germany");
        homePage.checkToCheckboxByColumnNameAndRowIndex("NPO?", "3");
        homePage.actionToRowByRowIndex("3", "Move Up");
        homePage.sleepInSecond(3);

        homePage.enterToTextboxByColumnNameAndRowIndex("Company", "6", "XYZ Company");
        homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person", "6", "Susan McLaren");
        homePage.enterToTextboxByColumnNameAndRowIndex("Order Placed", "6", "2");
        homePage.selectToDropdownByColumnNameAndRowIndex("Country", "6", "Hong Kong");
        homePage.checkToCheckboxByColumnNameAndRowIndex("NPO?", "6");
        homePage.actionToRowByRowIndex("6", "Insert");
        homePage.sleepInSecond(3);
    }

    @Test
    public void Table_05_Get_All_Value() {
        //UI
        List<String>  countryActualValue = homePage.getColumnAllValueByColumnName("Country");
        System.out.println(countryActualValue.size());

        List<String> countryFemaleValue = homePage.getColumnAllValueByColumnName("Females");
        System.out.println(countryFemaleValue.size());
        //Database or File Data or API

    }

    @AfterClass
    public void afterClass() {
        closeBrowser(driver);
    }


    private WebDriver driver;
    private HomePageObject homePage;


}

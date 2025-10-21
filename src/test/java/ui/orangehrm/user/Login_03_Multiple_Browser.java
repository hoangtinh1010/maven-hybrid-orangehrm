package ui.orangehrm.user;

//import các class/interface từ package khác

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;


//Cách 1: khai báo và khởi tao BasePage
public class Login_03_Multiple_Browser extends BaseTest {

     private WebDriver driver;
     private BasePage basePage;
     private String appURL ;

     @Parameters({"browser","appUrl"})
    @BeforeClass
    public void beforeClass(String browserName , String appURL) {
         this.appURL = appURL;
        basePage= BasePage.getInstance();
        driver = getBrowserDriver(browserName, appURL);
         }

    @Test
    public void Login_01_Empty() {
        basePage.openPageUrl(driver, appURL);
        basePage.sendKeyToElement(driver, "//input[@name='username']", "");
        basePage.sendKeyToElement(driver, "//input[@name='password']", "");

        basePage.clickToElement(driver, "//button[@type='submit']");

        // Verify error message for empty username
        Assert.assertEquals(basePage.getElementText(driver,"//input[@name='username']/parent::div/following-sibling::span"), "Required");
        Assert.assertEquals(basePage.getElementText(driver,"//input[@name='password']/parent::div/following-sibling::span"), "Required");

    }

    @Test
    public void Login_02_Invalid_User() {
        basePage.openPageUrl(driver, appURL);
        basePage.sendKeyToElement(driver, "//input[@name='username']", "Admin123");
        basePage. sendKeyToElement(driver, "//input[@name='password']", "admin123");

        basePage.clickToElement(driver, "//button[@type='submit']");

        // Verify error message for empty username
        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='orangehrm-login-error']//p[contains(@class,'oxd-alert-content-text')]"), "Invalid credentials");
    }

    @Test
    public void Login_03_Invalid_Password() {
        basePage.openPageUrl(driver, appURL);
        basePage.sendKeyToElement(driver, "//input[@name='username']", "Admin");
        basePage.sendKeyToElement(driver, "//input[@name='password']", "admin1235677");

        basePage.clickToElement(driver, "//button[@type='submit']");

        // Verify error message for empty username
        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='orangehrm-login-error']//p[contains(@class,'oxd-alert-content-text')]"), "Invalid credentials");
    }

    @Test
    public void Login_04_Valid_Password() {
        basePage.openPageUrl(driver, appURL);
        basePage.sendKeyToElement(driver, "//input[@name='username']", "Admin");
        basePage.sendKeyToElement(driver, "//input[@name='password']", "admin123");
        basePage.clickToElement(driver, "//button[@type='submit']");

        Assert.assertTrue(isAllLoadingSpinnerInvisible());

        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='oxd-topbar-header-title']//h6"),"Dashboard");
    }
    public boolean isAllLoadingSpinnerInvisible(){
        return basePage.waitListElementInvisible(driver, "//div[@class='oxd-loading-spinner']");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

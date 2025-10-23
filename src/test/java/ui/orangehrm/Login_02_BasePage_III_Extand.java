package ui.orangehrm;

//import các class/interface từ package khác

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


//Cách 1: khai báo và khởi tao BasePage
public class Login_02_BasePage_III_Extand extends BasePage {

     private WebDriver driver;
     private String pageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void Login_01_Empty() {
        openPageUrl(driver, pageUrl);
        sendKeyToElement(driver, "//input[@name='username']", "");
        sendKeyToElement(driver, "//input[@name='password']", "");

        clickToElement(driver, "//button[@type='submit']");

        // Verify error message for empty username
        Assert.assertEquals(getElementText(driver,"//input[@name='username']/parent::div/following-sibling::span"), "Required");
        Assert.assertEquals(getElementText(driver,"//input[@name='password']/parent::div/following-sibling::span"), "Required");

    }

    @Test
    public void Login_02_Invalid_User() {
        openPageUrl(driver, pageUrl);
        sendKeyToElement(driver, "//input[@name='username']", "Admin123");
        sendKeyToElement(driver, "//input[@name='password']", "admin123");

        clickToElement(driver, "//button[@type='submit']");

        // Verify error message for empty username
        Assert.assertEquals(getElementText(driver,"//div[@class='orangehrm-login-error']//p[contains(@class,'oxd-alert-content-text')]"), "Invalid credentials");
    }

    @Test
    public void Login_03_Invalid_Password() {
        openPageUrl(driver, pageUrl);
        sendKeyToElement(driver, "//input[@name='username']", "Admin");
        sendKeyToElement(driver, "//input[@name='password']", "admin1235677");

        clickToElement(driver, "//button[@type='submit']");

        // Verify error message for empty username
        Assert.assertEquals(getElementText(driver,"//div[@class='orangehrm-login-error']//p[contains(@class,'oxd-alert-content-text')]"), "Invalid credentials");
    }

    @Test
    public void Login_04_Valid_Password() {
        openPageUrl(driver, pageUrl);
        sendKeyToElement(driver, "//input[@name='username']", "Admin");
        sendKeyToElement(driver, "//input[@name='password']", "admin123");
        clickToElement(driver, "//button[@type='submit']");

        Assert.assertTrue(isAllLoadingSpinnerInvisible());

        Assert.assertEquals(getElementText(driver,"//div[@class='oxd-topbar-header-title']//h6"),"Dashboard");
    }
    public boolean isAllLoadingSpinnerInvisible(){
        return waitListElementInvisible(driver, "//div[@class='oxd-loading-spinner']");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

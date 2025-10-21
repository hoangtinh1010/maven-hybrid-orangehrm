package ui.orangehrm.user;

//import các class/interface từ package khác
import javaSDET.Topic_01_Keywords;

//import thư viện
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;





public class Login_01_DRY {
     WebDriver driver;
     private Topic_01_Keywords topic1;
     WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void Login_01_Empty() {
        driver.findElement(By.name("username")).sendKeys("");
        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Verify error message for empty username
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='username']/parent::div/following-sibling::span")).getText(), "Required");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='password']/parent::div/following-sibling::span")).getText(), "Required");
    }

    @Test
    public void Login_02_Invalid_User() {
        driver.findElement(By.name("username")).sendKeys("Admin123");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Verify error message for empty username
        Assert.assertEquals(driver.findElement(By.cssSelector("p.oxd-alert-content-text")).getText(), "Invalid credentials");
    }

    @Test
    public void Login_03_Invalid_Password() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Verify error message for empty username
        Assert.assertEquals(driver.findElement(By.cssSelector("p.oxd-alert-content-text")).getText(), "Invalid credentials");
    }

    @Test
    public void Login_04_Valid_Password() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertTrue(isAllLoadingSpinnerInvisible());
    }
    public boolean isAllLoadingSpinnerInvisible(){
        return explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.oxd-loading-spinner"))));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

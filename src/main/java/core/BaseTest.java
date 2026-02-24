package core;
//import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import reportConfig.ExtentManager;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    WebDriver driver;

    protected WebDriver getBrowserDriver(String browserName, String appURL) {
//        Cach 1: Using if-else
//        if (browserName.equalsIgnoreCase("firefox")) {
//            driver = new FirefoxDriver();
//        } else if (browserName.equalsIgnoreCase("chrome")) {
//            driver = new ChromeDriver();
//        } else if (browserName.equalsIgnoreCase("edge")) {
//            driver = new EdgeDriver();
//            EdgeOptions edgeOptions = new EdgeOptions();
//            edgeOptions.addArguments("--edge-skip-compat-layer-relaunch");
//        } else {
//            throw new RuntimeException("Please enter valid browser name or not supported");
//        }
        BrowserList browserList =BrowserList.valueOf(browserName.toUpperCase());

        switch (browserList) {
             case FIREFOX:
                 driver = new FirefoxDriver();
                 break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--edge-skip-compat-layer-relaunch");
                break;
           case SAFARI:
               driver = new SafariDriver();
                    // MacOS only
            default:
                throw new RuntimeException("Please enter valid browser name or not supported");
        }
        driver.get(appURL);
//        driver.manage().window().setPosition(new Point(0,0));
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        return driver;
    }
    public WebDriver getDriver() {
        return this.driver;
    }

    protected void closeBrowser() {
        if (!(driver == null)) {
            driver.quit();
        }
    }
    protected void closeBrowser(WebDriver driver) {
        if (!(driver == null)) {
            driver.quit();
        }
    }

    protected int getRandomNumber() {
        return  new Random().nextInt(9999);
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);

        } catch (Throwable e) {
            pass = false;

            //Lấy hết các lỗi đang có của testcase hiện tại
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);

            //Set vào Report TestNG/ ReportNG
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

//    protected void takeScreenShot(){
//        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//        ExtentManager.getTest().log(LogStatus.INFO, "Test Failed", ExtentManager.getTest().addBase64ScreenShot(base64Screenshot));
//    }


}


package core;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

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
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}


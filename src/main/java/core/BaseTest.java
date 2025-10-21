package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;

    protected WebDriver getBrowserDriver(String browserName, String appURL) {
        switch (browserName.toLowerCase()) {
             case "firefox":
                 driver = new FirefoxDriver();
                 break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--edge-skip-compat-layer-relaunch");
                break;
            default:
                throw new RuntimeException("Please enter valid browser name or not supported");
        }
        driver.get(appURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}


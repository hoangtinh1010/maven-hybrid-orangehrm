package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_09 {
    String name;

    //Contructor
    public Topic_09(String name) {
        this.name=name;
    }

    // Khi chạy da luồng v gọi ddeesn hàm này
    //Phải hạy theo thu tu
    public synchronized WebDriver getDriver() {
        WebDriver driver = null;
        if (driver instanceof WebDriver) {
            driver= new FirefoxDriver();
        }
        return driver;
    }
}

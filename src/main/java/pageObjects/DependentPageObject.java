package pageObjects;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.DependentPageUI;

public class DependentPageObject extends BasePage {
    private WebDriver driver;
    public DependentPageObject(WebDriver driver) {
        this.driver = driver;
    }

}

package pageObjects.orangeHRM.EditNavigation;

import org.openqa.selenium.WebDriver;

public class DependentPageObject extends EditNavigatorPageObject {
    private WebDriver driver;
    public DependentPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}

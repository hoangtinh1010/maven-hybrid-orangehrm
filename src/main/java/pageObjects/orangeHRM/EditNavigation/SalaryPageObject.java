package pageObjects.orangeHRM.EditNavigation;

import org.openqa.selenium.WebDriver;

public class SalaryPageObject extends EditNavigatorPageObject {
    private WebDriver driver;
    public SalaryPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}

package pageFactory.orangeHRM;

import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPageObject extends BasePageFactory {
    private WebDriver driver;

    @FindBy(xpath = "//span[text()='PIM']/parent::a")
    private WebElement pimMenu;

    @FindBy(xpath = "//div[@class='oxd-loading-spinner']")
    private List<WebElement> loadingSpinner;


    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickToPIMMenu() {
        waitElementClickable(driver,pimMenu);
        clickToElement(pimMenu);

    }

    public boolean isLoadingSpinnerDisappear() {
        return waitListElementInvisible(driver,loadingSpinner);
    }
}

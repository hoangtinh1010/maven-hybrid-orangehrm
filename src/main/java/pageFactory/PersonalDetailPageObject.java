package pageFactory;

import core.BasePage;
import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUIs.PersonalDetailPageUI;

import java.util.List;

public class PersonalDetailPageObject extends BasePageFactory {
    private WebDriver driver;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameTextbox;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameTextbox;

    @FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div/input")
    private WebElement employeeIdTextbox;

    @FindBy(xpath = "//div[@class='orangehrm-edit-employee-name']/h6")
    private WebElement displayedFullName;

    @FindBy(xpath = "//div[@class='oxd-loading-spinner']")
    private List<WebElement> loadingSpinner;

    public PersonalDetailPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstNameTextBoxValue() {
        waitElementVisible(driver, firstNameTextbox);
        return getElementDOMProperty(firstNameTextbox, "value");
    }

    public String getLastNameTextBoxValue() {
        waitElementVisible(driver, lastNameTextbox);
        return getElementDOMProperty(lastNameTextbox, "value");
    }


    public String getEmployeeIDTextBoxValue() {
        waitElementVisible(driver, employeeIdTextbox);
        return getElementDOMProperty(employeeIdTextbox, "value");
    }

    public String getDisplayedFullname() {
        return null;
    }

    public boolean isLoadingSpinnerDisappear() {
        return waitListElementInvisible(driver, loadingSpinner);
    }

    ;
}


package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.EditNavigation.ContactDetailPageObject;
import pageObjects.orangeHRM.EditNavigation.PersonalDetailPageObject;


public class PageGeneratorManager {
    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static AddEmployeePageObject getAddEmployeePage(WebDriver driver) {
        return new AddEmployeePageObject(driver);
    }

    public static ContactDetailPageObject getContactDetailPage(WebDriver driver) {
        return new ContactDetailPageObject(driver);
    }
    public static DashboardPageObject getDashboardPage(WebDriver driver) {
        return new DashboardPageObject(driver);
    }
    public static EmployeeListPageObject getEmployeeListPage(WebDriver driver) {
        return new EmployeeListPageObject(driver);
    }
    public static PersonalDetailPageObject getPersonalDetailPage(WebDriver driver) {
        return new PersonalDetailPageObject(driver);
    }

    //60 Class Page Object ~ 60 Methods
}
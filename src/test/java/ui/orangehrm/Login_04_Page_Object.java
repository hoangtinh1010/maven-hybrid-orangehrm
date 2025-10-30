package ui.orangehrm;

//import các class/interface từ package khác

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;


//Cách 1: khai báo và khởi tao BasePage
public class Login_04_Page_Object extends BaseTest {
    private String appURL;
    //Follow nghiệp vụ: (1) Login to system -> (2) Dashboard: Navigate to PIM page
    // -> (3) Emloyee List:  Add Employee -> (4) Personal Detail: Verify ->Edit Employee

    @Parameters({"browser", "appUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL) {
        this.appURL = appURL;
        driver = getBrowserDriver(browserName, appURL);
        loginPage = new LoginPageObject(driver);
        username= "Admin";
        password= "admin123";
        firstName= "Automation";
        lastName= "FC";
    }

    @Test
    public void Employee_01_CreateNewEmployee() {

        //Action on Login Page
        loginPage.enterToUsernameTextbox(username);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        //Action of Dashboard Page
        dashboardPage = new DashboardPageObject(driver);
        Assert.assertTrue(dashboardPage.isLoadingSpinnerDisappear(driver));

        dashboardPage.clickToPIMMenu();

        //Action of Employee List Page
        employeeListPage = new EmployeeListPageObject(driver);
        Assert.assertTrue(employeeListPage.isLoadingSpinnerDisappear(driver));
        employeeListPage.clickToAddEmployeeButton();

        //Action of Add Employee Page
        addEmployeePage = new AddEmployeePageObject(driver);
        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));

        addEmployeePage.enterToFirstNameTextbox(firstName);
        addEmployeePage.enterToLastNameTextbox(lastName);
        String employeeID = addEmployeePage.getEmployeeIDValue();
        addEmployeePage.clickToSaveButton();

        //Action of Personal Detail Page
        personalDetailPage = new PersonalDetailPageObject(driver);
        Assert.assertTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));
        personalDetailPage.sleepInSecond(2);

        Assert.assertEquals(personalDetailPage.getFirstNameTextBoxValue(), firstName);
        Assert.assertEquals(personalDetailPage.getLastNameTextBoxValue(), lastName);
        Assert.assertEquals(personalDetailPage.getEmployeeIDTextBoxValue(), employeeID);
        Assert.assertEquals(personalDetailPage.getDisplayedFullname(),firstName + " " + lastName);

    }

    private WebDriver driver;
    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailPageObject personalDetailPage;
    private String firstName, lastName, username, password;

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}

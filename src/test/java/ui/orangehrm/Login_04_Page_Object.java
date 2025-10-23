package ui.orangehrm;

//import các class/interface từ package khác

import core.BasePage;
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
        loginPage = new LoginPageObject();
    }

    @Test
    public void Employee_01_CreateNewEmployee() {

        //Action on Login Page
        loginPage.enterToUsernameTextbox("Admin");
        loginPage.enterToPasswordTextbox("admin123");
        loginPage.clickToLoginButton();

        //Action of Dashboard Page
        dashboardPage = new DashboardPageObject();
        dashboardPage.clickToPIMMenu();

        //Action of Employee List Page
        employeeListPage = new EmployeeListPageObject();
        employeeListPage.clickToAddEmployeeButton();

        //Action of Add Employee Page
        addEmployeePage = new AddEmployeePageObject();
        addEmployeePage.enterToFirstNameTextbox("Automation");
        addEmployeePage.enterToLastNameTextbox("FC");
        String employeeID = addEmployeePage.getEmployeeIDValue();
        addEmployeePage.clickToSaveButton();

        //Action of Personal Detail Page
        personalDetailPage = new PersonalDetailPageObject();
        Assert.assertEquals(personalDetailPage.getFirstNameTextBoxValue(), "Automation");
        Assert.assertEquals(personalDetailPage.getLastNameTextBoxValue(), "FC");
        Assert.assertEquals(personalDetailPage.getEmployeeIDValue(), employeeID);
        Assert.assertEquals(personalDetailPage.getDisplayedFullname(),"Automation FC");

    }

    @Test
    public void Employee_02_EditEmployee() {

    }

    private WebDriver driver;
    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailPageObject personalDetailPage;

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

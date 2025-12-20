package ui.orangehrm;


import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.AddEmployeePageObject;
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.EditNavigation.*;
import pageObjects.orangeHRM.EmployeeListPageObject;
import pageObjects.orangeHRM.LoginPageObject;


public class Level_11_By_Locator extends BaseTest {
    private String appURL;
    //Follow nghiệp vụ: (1) Login to system -> (2) Dashboard: Navigate to PIM page
    // -> (3) Emloyee List:  Add Employee -> (4) Personal Detail: Verify ->Edit Employee

    @Parameters({"browser", "appURL"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL) {
        this.appURL = appURL;
        driver = getBrowserDriver(browserName, appURL);
        loginPage = PageGenerator.getPage(LoginPageObject.class, driver);
        username = "hoangtinh";
        password = "Tinh@@111";
        firstName = "Automation";
        lastName = "Tinh";
    }

    @Test
    public void Employee_01_CreateNewEmployee() {

        loginPage.enterToUsernameTextbox(username);
        loginPage.enterToPasswordTextbox(password);
        dashboardPage = loginPage.clickToLoginButton();

        Assert.assertTrue(dashboardPage.isLoadingSpinnerDisappear(driver));

        employeeListPage = dashboardPage.clickToPIMMenu();
        Assert.assertTrue(employeeListPage.isLoadingSpinnerDisappear(driver));

        addEmployeePage = employeeListPage.clickToAddEmployeeButton();
        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));

        addEmployeePage.enterToFirstNameTextbox(firstName);
        addEmployeePage.enterToLastNameTextbox(lastName);
        employeeID = addEmployeePage.getEmployeeIDValue();

        personalDetailPage = addEmployeePage.clickToSaveButton();

        Assert.assertTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));
        personalDetailPage.sleepInSecond(4);

        Assert.assertEquals(personalDetailPage.getFirstNameTextBoxValue(), firstName);
        Assert.assertEquals(personalDetailPage.getLastNameTextBoxValue(), lastName);
        Assert.assertEquals(personalDetailPage.getEmployeeIDTextBoxValue(), employeeID);
        Assert.assertEquals(personalDetailPage.getDisplayedFullname(), firstName + " " + lastName);

    }

    @Test(enabled = false)
    public void Employee_02_Dynamic_Page() {
        // Từ Personal qua Contact
        contactDetailPage = personalDetailPage.openContactDetailsPage();

        // Từ Contact qua Job
        jobPage = (JobPageObject) contactDetailPage.openEditNavigatorPageByName("Job");

        // Từ Job qua Dependent
        dependentPage = (DependentPageObject) jobPage.openEditNavigatorPageByName("Dependents");

        // Từ Dependent qua Personal
        personalDetailPage = (PersonalDetailPageObject) dependentPage.openEditNavigatorPageByName("Personal Details");

        // Từ Job qua Personal
        personalDetailPage = (PersonalDetailPageObject) jobPage.openEditNavigatorPageByName("Personal Details");

        // Từ Personal qua Job
        jobPage = (JobPageObject) personalDetailPage.openEditNavigatorPageByName("Job");

        // Từ Personal qua Dependent
        dependentPage = (DependentPageObject) personalDetailPage.openEditNavigatorPageByName("Dependents");

        // Từ Dependent qua Salary
        salaryPage = (SalaryPageObject) dependentPage.openEditNavigatorPageByName("Salary");

    }

    @Test
    public void Employee_03_Dynamic_Page() {
        // Từ Personal qua Contact
        contactDetailPage = personalDetailPage.openContactDetailsPage();

        // Từ Contact qua Job
         contactDetailPage.openEditNavigatorByName("Job");
        jobPage = PageGenerator.getPage(JobPageObject.class, driver);

        // Từ Job qua Dependent
         jobPage.openEditNavigatorByName("Dependents");
        dependentPage = PageGenerator.getPage(DependentPageObject.class, driver);

        // Từ Dependent qua Personal
         dependentPage.openEditNavigatorByName("Personal Details");
        personalDetailPage = PageGenerator.getPage(PersonalDetailPageObject.class, driver);

        // Từ Job qua Personal
       jobPage.openEditNavigatorByName("Personal Details");
        personalDetailPage = PageGenerator.getPage(PersonalDetailPageObject.class, driver);

        // Từ Personal qua Job
        personalDetailPage.openEditNavigatorByName("Job");
        jobPage = PageGenerator.getPage(JobPageObject.class, driver);

        // Từ Personal qua Dependent
        personalDetailPage.openEditNavigatorByName("Dependents");
        dependentPage = PageGenerator.getPage(DependentPageObject.class, driver);

        // Từ Dependent qua Salary
        dependentPage.openEditNavigatorByName("Salary");
        salaryPage = PageGenerator.getPage(SalaryPageObject.class, driver);

    }
    private WebDriver driver;
    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailPageObject personalDetailPage;
    private ContactDetailPageObject contactDetailPage;
    private JobPageObject jobPage;
    private DependentPageObject dependentPage;
    private SalaryPageObject salaryPage;
    private String firstName, lastName, username, password, employeeID;

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}

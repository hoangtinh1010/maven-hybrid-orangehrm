package ui.orangehrm;


//import com.relevantcodes.extentreports.LogStatus;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
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

import java.lang.reflect.Method;


public class Level_14_Extend_Report_v2 extends BaseTest {
    private String appURL;
    //Follow nghiệp vụ: (1) Login to system -> (2) Dashboard: Navigate to PIM page
    // -> (3) Emloyee List:  Add Employee -> (4) Personal Detail: Verify ->Edit Employee

    @Parameters({"browser", "appURL"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL) {
        this.appURL = appURL;
        driver = getBrowserDriver(browserName, appURL);
        loginPage = PageGenerator.getPage(LoginPageObject.class, driver);
        adminUsername = "hoangtinh";
        adminPassword = "Tinh@@111";
        employeeFirstName = "Automation";
        employeeLastName = "Tinh";
    }

    @Test
    public void Employee_01_CreateNewEmployee(Method method) {
//        ExtentManager.startTest(method.getName(),"Employee_01_CreateNewEmployee");
//        ExtentManager.getTest().log(LogStatus.INFO, "NewEmployee_01 - Step 01: Open 'New Customer' page");
//        ExtentManager.getTest().log(LogStatus.INFO,"NewEmployee_01 - Step 01: Enter to 'Username' ang 'Password' with info: " + adminUsername + " | " + adminPassword);
//        loginPage.enterToUsernameTextbox(adminUsername);
//        loginPage.enterToPasswordTextbox(adminPassword);
//
//
//        ExtentManager.getTest().log(LogStatus.INFO,"NewEmployee_01 - Step 02: Click to 'Login' button and navigate to 'Dashboard' page");
//        dashboardPage = loginPage.clickToLoginButton();
//        Assert.assertTrue(dashboardPage.isLoadingSpinnerDisappear(driver));
//        dashboardPage.sleepInSecond(2);
//
//
//        ExtentManager.getTest().log(LogStatus.INFO,"NewEmployee_01 - Step 03: Navigate to 'Dashboard' page");
//        employeeListPage = dashboardPage.clickToPIMMenu();
//        Assert.assertTrue(employeeListPage.isLoadingSpinnerDisappear(driver));
//        employeeListPage.sleepInSecond(2);
//
//        ExtentManager.getTest().log(LogStatus.INFO,"NewEmployee_01 - Step 04: Click to 'Add Employee' button and open 'Add Employee' page");
//        addEmployeePage = employeeListPage.clickToAddEmployeeButton();
//        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));
//
//        ExtentManager.getTest().log(LogStatus.INFO,"NewEmployee_01 - Step 05: Enter to 'First Name' and 'Last Name' textbox with data: " + employeeFirstName + " | " + employeeLastName);
//        addEmployeePage.enterToFirstNameTextbox(employeeFirstName);
//        addEmployeePage.enterToLastNameTextbox(employeeLastName);
//        employeeID = addEmployeePage.getEmployeeIDValue();
//
//        ExtentManager.getTest().log(LogStatus.INFO,"NewEmployee_01 - Step 06: Click to 'Save' button and navigate to 'Personal Detail' page");
//        personalDetailPage = addEmployeePage.clickToSaveButton();
//        Assert.assertTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));
//        personalDetailPage.sleepInSecond(4);
//
//        ExtentManager.getTest().log(LogStatus.INFO,"NewEmployee_01 - Step 07: Verify  Employee is displayed: " + employeeFirstName);
//        Assert.assertEquals(personalDetailPage.getFirstNameTextBoxValue(), employeeLastName);
//
//        ExtentManager.getTest().log(LogStatus.INFO,"NewEmployee_01 - Step 08: Verify Last Name is displayed: " + employeeLastName);
//        Assert.assertEquals(personalDetailPage.getLastNameTextBoxValue(), employeeFirstName);
//
//        ExtentManager.getTest().log(LogStatus.INFO,"NewEmployee_01 - Step 09: Verify Employee ID is displayed: " + employeeID);
//        Assert.assertEquals(personalDetailPage.getEmployeeIDTextBoxValue(), employeeID);

//        ExtentManager.endTest();
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

    @Test (enabled = false)
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
    private String employeeFirstName, employeeLastName, adminUsername, adminPassword, employeeID;

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}

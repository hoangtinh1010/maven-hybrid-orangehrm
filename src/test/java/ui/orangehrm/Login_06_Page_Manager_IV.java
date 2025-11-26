package ui.orangehrm;



import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;


//Cách 4: Dùng Page Generator Generic
public class Login_06_Page_Manager_IV extends BaseTest {
    private String appURL;
    //Follow nghiệp vụ: (1) Login to system -> (2) Dashboard: Navigate to PIM page
    // -> (3) Emloyee List:  Add Employee -> (4) Personal Detail: Verify ->Edit Employee

    @Parameters({"browser", "appUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL) {
        this.appURL = appURL;
        driver = getBrowserDriver(browserName, appURL);
        PageGeneratorGeneric.getPage(LoginPageObject.class, driver);
        username= "hoangtinh";
        password= "Tinh@@111";
        firstName= "Automation";
        lastName= "FC";
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
        Assert.assertEquals(personalDetailPage.getDisplayedFullname(),firstName + " " + lastName);

    }

    @Test
    public void Employee_02_ContactDetail() {
        contactDetailPage = personalDetailPage.openContactDetailsPage();
        // tiếp tục viết các bước kiểm thử cho trang Contact Detail
    }

    private WebDriver driver;
    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailPageObject personalDetailPage;
    private ContactDetailPageObject contactDetailPage;
    private String firstName, lastName, username, password,employeeID;

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}

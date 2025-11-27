package ui.orangehrm;


import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;


public class Login_07_Switch_Page extends BaseTest {
    private String appURL;
    //Follow nghiệp vụ: (1) Login to system -> (2) Dashboard: Navigate to PIM page
    // -> (3) Emloyee List:  Add Employee -> (4) Personal Detail: Verify ->Edit Employee

    @Parameters({"browser", "appUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL) {
        this.appURL = appURL;
        driver = getBrowserDriver(browserName, appURL);
        loginPage = PageGeneratorGeneric.getPage(LoginPageObject.class, driver);
        username = "hoangtinh";
        password = "Tinh@@111";
        firstName = "Automation";
        lastName = "Tinh";
    }

    @Test
    public void Employee_01_CreateNewEmployee() {
        // Login cũng kế thừa BasePage nên nó cũng gọi các hàm này ra dùng được
        // Chạy sẽ fail vì sai Busineess Logic
        // 1 - Nguoi viết code phải nắm rõ Business Logic để viết code đúng/gọi trang đúng (ko gọi bừa bãi)
        // 2 - Ràng buộc về mặt codeing (Bài sau)

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

    @Test
    public void Employee_02_Switch_Page() {
        // Từ Personal qua Contact
        contactDetailPage = personalDetailPage.openContactDetailsPage(driver);

        // Từ Contact qua Job
        jobPage = contactDetailPage.openJobPage(driver);

        // Từ Job qua Dependent
        dependentPage = jobPage.openDependentPage(driver);

        // Từ Dependent qua Personal
        personalDetailPage = dependentPage.openPersonalDetailPage(driver);

        // Từ Job qua Personal
        personalDetailPage = jobPage.openPersonalDetailPage(driver);

        // Từ Personal qua Job
        jobPage = personalDetailPage.openJobPage(driver);
        dependentPage = personalDetailPage.openDependentPage(driver);



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
    private String firstName, lastName, username, password, employeeID;

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}

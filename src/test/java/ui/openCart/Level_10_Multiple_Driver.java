package ui.openCart;


import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.openCart.admin.AdminCustomerPO;
import pageObjects.openCart.admin.AdminDashboardPO;
import pageObjects.openCart.admin.AdminLoginPO;
import pageObjects.openCart.user.UserHomePO;
import pageObjects.openCart.user.UserLoginPO;
import pageObjects.openCart.user.UserMyAccountPO;
import pageObjects.openCart.user.UserRegisterPO;


public class Level_10_Multiple_Driver extends BaseTest {
    
    @Parameters({"browser", "userURL", "adminURL"})
    @BeforeClass
    public void beforeClass(String browserName, String userURL, String adminURL) {

        //Gán giá trị cho biến toàn cục
        this.userURL = userURL;
        this.adminURL = adminURL;

        adminUser = "hoangtinh";
        adminPassWord="Tinh@@111";

        userFirstName = "Auto";
        userLastName = "Hoang Tinh";
        userEmail="hoangtinh"+ getRandomNumber() +"@abc.com";
        userPassword = "123456";

        //Mở Driver cho trang User
        userDriver = getBrowserDriver(browserName, userURL);
        userHomepage = PageGenerator.getPage(UserHomePO.class, userDriver);


        // Mở Driver cho trang Admin
        adminDriver = getBrowserDriver(browserName, adminURL);
        adminLoginPage = PageGenerator.getPage(AdminLoginPO.class, adminDriver);

    }


    @Test(enabled = false)
    public void OpenCart_04_Multiple_Browser() {
        //USER - Firefox của USER chạy tiếp
        userHomepage.clickToMyAccountAtFooter();
        userLoginPage = PageGenerator.getPage(UserLoginPO.class, adminDriver);

        userRegisterPage = userLoginPage.clickToContinueButton();
        userRegisterPage.enterToFirstName(userFirstName);
        userRegisterPage.enterToLastName(userLastName);
        userRegisterPage.enterToEmail(userEmail);
        userRegisterPage.enterToPassword(userPassword);

        userRegisterPage.acceptPrivacyPolicy();
        userRegisterPage.clickToContinueButton();
        Assert.assertTrue(userRegisterPage.isSuccessMessageDisplayed());
        // Không logout nên nó vẫn ở trang Resgister

        // ADMIN - Firefox của ADMIN chạy tiếp
        adminLoginPage.enterToUsername(adminUser);
        adminLoginPage.enterToPassword(adminPassWord);
        adminDashboardPage = adminLoginPage.clickToLoginButton();
        Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());

        adminCustomerPage = adminDashboardPage.openCustomerPage();
        Assert.assertTrue(adminCustomerPage.isCustomerHeaderDisplayed());

        // USER - Firefox của USER chạy tiếp
        userHomepage.clickToMyAccountAtFooter();
        userMyAccountPage= PageGenerator.getPage(UserMyAccountPO.class, adminDriver);
        Assert.assertTrue( userMyAccountPage.isMyAccountPageDisplayed());

    }

    @Test


    @AfterClass
    public void afterClass() {
        closeBrowser(adminDriver);
        closeBrowser(userDriver);
    }



    // Biến Non-Static
    private WebDriver adminDriver;
    private WebDriver userDriver;

    private AdminLoginPO adminLoginPage;
    private AdminCustomerPO adminCustomerPage;
    private AdminDashboardPO adminDashboardPage;
    private UserLoginPO userLoginPage;
    private UserHomePO userHomepage;
    private UserRegisterPO userRegisterPage;
    private UserMyAccountPO userMyAccountPage;

    private String userURL, adminURL;
    private String userWindowID, adminWindowID;
    private String userFirstName, userLastName,userEmail, userPassword, adminUser, adminPassWord;


}

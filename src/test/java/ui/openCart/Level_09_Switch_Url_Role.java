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


public class Level_09_Switch_Url_Role extends BaseTest {
    private WebDriver driver;

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

        //Khởi chạy browser và mở userURL (User) lên
        driver = getBrowserDriver(browserName, userURL);
        userHomepage = PageGenerator.getPage(UserHomePO.class, driver);

    }

    @Test(enabled = false)
    public void OpenCart_01_Login_Logout() {
        /*GIỐNG HÀNH VI NGƯỜI DUNG */
        userHomepage.clickToMyAccountAtFooter();
        userLoginPage = PageGenerator.getPage(UserLoginPO.class, driver);

        userRegisterPage = userLoginPage.clickToContinueButton();
        userRegisterPage.enterToFirstName(userFirstName);
        userRegisterPage.enterToLastName(userLastName);
        userRegisterPage.enterToEmail(userEmail);
        userRegisterPage.enterToPassword(userPassword);

        userRegisterPage.acceptPrivacyPolicy();
        userRegisterPage.clickToContinueButton();
       Assert.assertTrue(userRegisterPage.isSuccessMessageDisplayed());

       //Logout
        userHomepage = userRegisterPage.clickLogoutLinkAtUserSite(driver);

        // User -> Admin
        userRegisterPage.openAdminSite(driver,adminURL);
        adminLoginPage = PageGenerator.getPage(AdminLoginPO.class, driver);

        // Login
        adminLoginPage.enterToUsername(adminUser);
        adminLoginPage.enterToPassword(adminPassWord);
        adminDashboardPage = adminLoginPage.clickToLoginButton();

        adminCustomerPage = adminDashboardPage.openCustomerPage();

        // Logout
        adminLoginPage =  adminCustomerPage.clickLogoutLinkAtAdminSite(driver);

        // Admin -> User
        userHomepage = adminLoginPage.openUserSite(driver,userURL);

         userHomepage.clickToMyAccountAtFooter();
        userLoginPage = PageGenerator.getPage(UserLoginPO.class, driver);

        // Login
        userLoginPage.enterToEmail(userEmail);
        userLoginPage.enterToPassword(userPassword);
        userMyAccountPage = userLoginPage.clickToLoginButton();
        Assert.assertTrue( userMyAccountPage.isMyAccountPageDisplayed());

        //User -> Admin
        // Login bên Admin
        // Thao tác bên Admin
        //Logout khỏi Admin

        //Quay lại User
        //Login bên User
        // Thao tác bên User


    }

    @Test(enabled = false)
    public void OpenCart_02_Login_Without_Logout() {
        /* TIỆN CHO VIỆC DEVELOP/TESTING*/
        // User vào đăng ký tai khoản
        // User không logout
        // Chuyển qua tragn Admin -> Login 1 lần
        // Admin vào verify đơn hàng

        //USER
        userHomepage.clickToMyAccountAtFooter();
        userLoginPage = PageGenerator.getPage(UserLoginPO.class, driver);

        userRegisterPage = userLoginPage.clickToContinueButton();
        userRegisterPage.enterToFirstName(userFirstName);
        userRegisterPage.enterToLastName(userLastName);
        userRegisterPage.enterToEmail(userEmail);
        userRegisterPage.enterToPassword(userPassword);

        userRegisterPage.acceptPrivacyPolicy();
        userRegisterPage.clickToContinueButton();
        Assert.assertTrue(userRegisterPage.isSuccessMessageDisplayed());

        // Không logout nên nó vẫn ở trang Resgister


        // user -> ADMIN
        userRegisterPage.openAdminSite(driver,adminURL);
        adminLoginPage = PageGenerator.getPage(AdminLoginPO.class, driver);

        // Login
        adminLoginPage.enterToUsername(adminUser);
        adminLoginPage.enterToPassword(adminPassWord);
        adminDashboardPage = adminLoginPage.clickToLoginButton();


        adminCustomerPage = adminDashboardPage.openCustomerPage();

        // Không logout nen nó vẫn ở trang Customer


        // Admin -> USER
        userHomepage = adminLoginPage.openUserSite(driver,userURL);

        userHomepage.clickToMyAccountAtFooter();
        userMyAccountPage= PageGenerator.getPage(UserMyAccountPO.class, driver);

        Assert.assertTrue( userMyAccountPage.isMyAccountPageDisplayed());

        //user -> ADMIN
        userMyAccountPage.openAdminSite(driver,adminURL);
        adminDashboardPage = PageGenerator.getPage(AdminDashboardPO.class, driver); //Fail vi dang co bug
        Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());

    }

    @Test
    public void OpenCart_03_Multiple_Tab() {
        //USER
        userHomepage.clickToMyAccountAtFooter();
        userLoginPage = PageGenerator.getPage(UserLoginPO.class, driver);

        userRegisterPage = userLoginPage.clickToContinueButton();
        userRegisterPage.enterToFirstName(userFirstName);
        userRegisterPage.enterToLastName(userLastName);
        userRegisterPage.enterToEmail(userEmail);
        userRegisterPage.enterToPassword(userPassword);

        userRegisterPage.acceptPrivacyPolicy();
        userRegisterPage.clickToContinueButton();

        Assert.assertTrue(userRegisterPage.isSuccessMessageDisplayed());

        userWindowID = userRegisterPage.getCurrentWindowID(driver);
        // Không logout nên nó vẫn ở trang Resgister

        // user -> ADMIN
        userRegisterPage.openUrlByNewTab(driver, adminURL);

        adminLoginPage = PageGenerator.getPage(AdminLoginPO.class, driver);

        // Login
        adminLoginPage.enterToUsername(adminUser);
        adminLoginPage.enterToPassword(adminPassWord);
        adminDashboardPage = adminLoginPage.clickToLoginButton();


        adminCustomerPage = adminDashboardPage.openCustomerPage();
        adminWindowID = adminCustomerPage.getCurrentWindowID(driver);
        // Không logout nen nó vẫn ở trang Customer

        // Admin -> USER
        adminCustomerPage.switchToWindowByID(driver, adminWindowID);

        userRegisterPage = PageGenerator.getPage(UserRegisterPO.class, driver);

        //Vào userHomepage
        userHomepage = userRegisterPage.openUserHomeLogo(driver);
        userHomepage.clickToMyAccountAtFooter();
        userMyAccountPage = PageGenerator.getPage(UserMyAccountPO.class, driver);

         Assert.assertTrue( userMyAccountPage.isMyAccountPageDisplayed());

        //user -> ADMIN
        userMyAccountPage.switchToWindowByID(driver, userWindowID);
        adminCustomerPage = PageGenerator.getPage(AdminCustomerPO.class, driver);

        //Verify trang Admin Customer hiển thị
        Assert.assertTrue(adminCustomerPage.isCustomerHeaderDisplayed());
    }


    @AfterClass
    public void afterClass() {
        closeBrowser();
    }



    // Biến Non-Static

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

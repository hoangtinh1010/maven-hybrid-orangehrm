package pageObjects.openCart.admin;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.openCart.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    private WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUsername(String adminUserName) {
        waitElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, adminUserName);
    }
    public void enterToPassword(String adminPassWord) {
        waitElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassWord);
    }

    public AdminDashboardPO clickToLoginButton() {
        waitElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getPage(AdminDashboardPO.class, driver);
    }
}

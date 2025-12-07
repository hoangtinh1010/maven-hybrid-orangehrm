package pageObjects.openCart.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.openCart.admin.AdminDashboardPO;
import pageObjects.openCart.admin.AdminLoginPO;
import pageUIs.openCart.user.UserLoginPageUI;
import pageUIs.openCart.user.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstName(String firstName) {
        waitElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastName(String lastName) {
        waitElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void enterToEmail(String email) {
        waitElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToPassword(String password) {
        waitElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void acceptPrivacyPolicy() {
        waitElementClickable(driver, UserRegisterPageUI.PRIVACY_POLICY_SWITCH);
        checkToCheckbox(driver, UserRegisterPageUI.PRIVACY_POLICY_SWITCH);
    }

    public void clickToContinueButton() {
        waitElementClickable(driver, UserRegisterPageUI.CONTINUE_BUTTON);
        clickToElement(driver, UserRegisterPageUI.CONTINUE_BUTTON);
    }

    public boolean isSuccessMessageDisplayed() {
        waitElementVisible(driver, UserRegisterPageUI.CREATED_ACCOUNT_SUCCESS_MESSAGE);
        return isElementDisplayed(driver, UserRegisterPageUI.CREATED_ACCOUNT_SUCCESS_MESSAGE);
    }
    public void clickToSuccessContinueButton() {
        waitElementClickable(driver, UserRegisterPageUI.SUCCESS_CONTINUE_BUTTON);
        clickToElement(driver, UserRegisterPageUI.SUCCESS_CONTINUE_BUTTON);
    }


}

package pageObjects.openCart.admin;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.openCart.admin.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {
    private WebDriver driver;

    public AdminDashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public AdminCustomerPO openCustomerPage() {
        waitElementClickable(driver, AdminDashboardPageUI.CUSTOMERS_MENU);
        clickToElement(driver, AdminDashboardPageUI.CUSTOMERS_MENU);
        sleepInSecond(1);

        waitElementVisible(driver, AdminDashboardPageUI.CUSTOMERS_SUBMENU);
        clickToElement(driver, AdminDashboardPageUI.CUSTOMERS_SUBMENU);
        return PageGenerator.getPage(AdminCustomerPO.class, driver);
    }

    public boolean isDashboardHeaderDisplayed() {
        waitElementVisible(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
        return isElementDisplayed(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
    }
}

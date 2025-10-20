package core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {
    //Nguyen tac viet ham
    //1 - Access modifier: public/protected/private/default
    //public: Tat ca cac class trong cung/khac package deu su dung dươc cac ham nay
    //Chi cho class nao ke thua moi su dung duoc => Khong dung public
    //protected: Chi class nao ke thua moi sư dung duoc => Sẽ dùng
    //private: Chi cac ham trong class moi su dung
    //default: Chi cho cac class trong cung package moi su dung
    //2 - Kiểu du lieu cua ham (Data type): void/int/boolean/String/WebElement/List <WebElement>...
    //No lien quan den cai chuc nang minh viet trong than ham
    //Dung cai ham nao của Selenium, no tra ve kieu du lieu gi thi minh khai bao kieu du lieu do
    //3 - Ten ham: có y nghia, biet ham lam gi (ngan gon xuc tich)

    //4 - Tham so dau vao (nếu có): có thể có hoặc không
    // Dung cai ham nao cua Selenium, no can tham so dau vao gi thi minh khai bao tham so do
    //5 - Kieu tra ve: void/String/int/float/boolean/...
    //Neu như co return dư lieu tra ve thi phai khai bao kieu du lieu tra ve
    //Neu như co return thi no la step cuoi cung
    //-------------------------------------------------

    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();

    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    private Alert waitAlertPresence(WebDriver driver) {
       return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitAlertPresence(driver).dismiss();
    }

    public void sendKeyToAlert(WebDriver driver, String keyToSend) {
        waitAlertPresence(driver).sendKeys(keyToSend);
    }

    public String getAlertText (WebDriver driver) {
        return waitAlertPresence(driver).getText();
    }

    public void sleepInSecond(int timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void switchToWindowByID(WebDriver driver, String currentWindowID){

        Set<String> allWindows = driver.getWindowHandles();

        for (String id : allWindows) {
                        if (!id.equals(currentWindowID)) {
                driver.switchTo().window(id);
                break;

            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String expectedPageTitle){
        Set<String> allWindowIDs = driver.getWindowHandles();

        for (String id : allWindowIDs) {
            driver.switchTo().window(id);
            if (driver.getTitle().equals(expectedPageTitle)) {
                break;
            }
        }
        sleepInSecond(2);
    }

    public void switchToWindowByContainTitle(WebDriver driver, String expectedPageTitle){
        Set<String> allWindowIDs = driver.getWindowHandles();

        for (String id : allWindowIDs) {
            driver.switchTo().window(id);
            if (driver.getTitle().contains(expectedPageTitle)) {
                break;
            }
        }
        sleepInSecond(2);
    }

    public void closeAllWindowWithoutParent(WebDriver driver,String parentWindowID){

        Set<String> allWindowIDs = driver.getWindowHandles();

        for (String id : allWindowIDs) {
            if (!id.equals(parentWindowID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindowID);
    }

}


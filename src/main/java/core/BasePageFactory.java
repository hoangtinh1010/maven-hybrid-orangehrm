package core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.BasePageUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePageFactory {

 public static BasePageFactory getInstance() {
        return new BasePageFactory();
        //Ham static co nhiem vụ lay ra instance/đối tượng cua class
      //Một biến static/ham static có the gọi ra trực tiếp từ phạm vi class
    }
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
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
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

    public String getAlertText(WebDriver driver) {
        return waitAlertPresence(driver).getText();
    }

    public void sleepInSecond(int timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void switchToWindowByID(WebDriver driver, String currentWindowID) {

        Set<String> allWindows = driver.getWindowHandles();

        for (String id : allWindows) {
            if (!id.equals(currentWindowID)) {
                driver.switchTo().window(id);
                break;

            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String expectedPageTitle) {
        Set<String> allWindowIDs = driver.getWindowHandles();

        for (String id : allWindowIDs) {
            driver.switchTo().window(id);
            if (driver.getTitle().equals(expectedPageTitle)) {
                break;
            }
        }
        sleepInSecond(2);
    }

    public void switchToWindowByContainTitle(WebDriver driver, String expectedPageTitle) {
        Set<String> allWindowIDs = driver.getWindowHandles();

        for (String id : allWindowIDs) {
            driver.switchTo().window(id);
            if (driver.getTitle().contains(expectedPageTitle)) {
                break;
            }
        }
        sleepInSecond(2);
    }

    public void closeAllWindowWithoutParent(WebDriver driver, String parentWindowID) {

        Set<String> allWindowIDs = driver.getWindowHandles();

        for (String id : allWindowIDs) {
            if (!id.equals(parentWindowID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindowID);
    }

//    Thao tác với Element
    //PageFactory là define kiểu WebElement

    public void clickToElement( WebElement element) {
        element.click();
    }

    public void sendKeyToElement( WebElement element, String keyToSend) {
        element.clear();
        element.sendKeys(keyToSend);
    }



    public String getElementDOMAttribute(WebElement element, String attributeName) {
        return element.getDomAttribute(attributeName);
    }

    public String getElementDOMProperty(WebElement element,String propertyName) {
       return element.getDomProperty(propertyName);
    }

    public String getElementText ( WebElement element) {
       return element.getText();
    }


    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }

    public boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }




    public WebElement waitElementVisible(WebDriver driver,WebElement element) {
       return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> waitListElementVisible(WebDriver driver, List<WebElement> elements) {
         return new  WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public boolean waitElementSelected(WebDriver driver,WebElement element) {
       return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeSelected(element));
    }

    public WebElement waitElementClickable(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean waitElementInvisible(WebDriver driver, WebElement element) {
       return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    public boolean waitListElementInvisible(WebDriver driver,List<WebElement> elements) {
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    private final int SHORT_TIMEOUT =10;
    private final int LONG_TIMEOUT = 30;

}


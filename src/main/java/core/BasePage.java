package core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;
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

    private By getByXpath(String locator) {
        return By.xpath(locator);
    }

    private WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getByXpath(locator));
    }   private List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getByXpath(locator));
    }

    public void clickToElement(WebDriver driver, String locator) {
        getWebElement(driver,locator).click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String keyToSend) {
        getWebElement(driver,locator).sendKeys(keyToSend);
    }

    public void selectItemInDropdown (WebDriver driver, String locator, String valueToSelect) {
       new Select(getWebElement(driver, locator)).selectByVisibleText(valueToSelect);
    }

    public String getSelectedItemInDropdown(WebDriver driver, String locator) {
        return new Select(getWebElement(driver, locator))
                .getFirstSelectedOption().getText();
    }

    public boolean isMultiSelectDropdown(WebDriver driver, String locator) {
        return new Select(getWebElement(driver, locator)).isMultiple();
    }

    public void selectItemInSelectableDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedTextItem) {
        clickToElement(driver, parentLocator);
        sleepInSecond(1);

        new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));

        List<WebElement> allItems = getListElement(driver, childLocator);

        for (WebElement item : allItems) {
            //So sánh với item mong muốn, nếu actualText = item mong muốn -> click
            if (item.getText().trim().equals(expectedTextItem)) {
                item.click();
                sleepInSecond(1);
                break;
            }

        }

    }

    public String getElementDOMAttribute(WebDriver driver ,String locator, String attributeName) {
        return getWebElement(driver,locator).getDomAttribute(attributeName);
    }

    public String getElementDOMProperty(WebDriver driver ,String locator, String propertyName) {
       return getWebElement(driver,locator).getDomProperty(propertyName);
    }

    public void getElementText (WebDriver driver, String locator) {
        getWebElement(driver,locator).getText();
    }

    public String getElementCss(WebDriver driver, String locator, String propertyName) {
       return getWebElement(driver,locator).getCssValue(propertyName);
    }

    public String getHexByRGBA(String rgbaColor) {
        return Color.fromString(rgbaColor).asHex().toUpperCase();
    }

    public int getListElementNumber(WebDriver driver, String locator) {
       return getListElement(driver,locator).size();
    }

    public void checkToCheckbox(WebDriver driver, String locator) {
        if (!isElementSelected(driver,locator)) {
            getWebElement(driver,locator).click();
        }
    }

    public void uncheckToCheckbox(WebDriver driver, String locator) {
        if (isElementSelected(driver,locator)) {
            getWebElement(driver,locator).click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getWebElement(driver,locator).isDisplayed();
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getWebElement(driver,locator).isSelected();
    }

    public boolean isElementEnabled(WebDriver driver, String locator) {
        return getWebElement(driver,locator).isEnabled();
    }

    public void switchToFrame(WebDriver driver, String locator) {
        driver.switchTo().frame(getWebElement(driver,locator));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void doubleClick(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getWebElement(driver,locator)).perform();
    }

    public void rightClick(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getWebElement(driver,locator)).perform();
    }

    public void moveToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getWebElement(driver,locator)).perform();
    }

    public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getWebElement(driver, sourceLocator),
                getWebElement(driver, targetLocator)).perform();
    }

    public void sendKeyBoardToElement(WebDriver driver, String locator, Keys keys) {
        new Actions(driver).sendKeys(getWebElement(driver,locator), keys).perform();
    }

    public Object executeForBrowser(WebDriver driver,String javaScript) {
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    public void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void highlightElement(WebDriver driver, String locator) {
        WebElement element = getWebElement(driver,locator);
        String originalStyle = getElementDOMAttribute(driver,locator,"style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver,locator));
        sleepInSecond(3);
    }

    public String getElementTextByJS(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;",getWebElement(driver,locator));
    }

    public void scrollToElementOnTop(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver,locator));
    }

    public void scrollToElementOnDown(WebDriver driver,String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver,locator));
    }

    public String getAttributeInDOM(WebDriver driver,String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver,locator));
    }

    public String getElementValidationMessage(WebDriver driver,String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver,locator));
    }

    public boolean isImageLoaded(WebDriver driver,String locator) {
        return (boolean) ((JavascriptExecutor) driver).
                executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getWebElement(driver,locator));
    }

    public void waitElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitListElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
    }

    public void waitElementSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeSelected(getByXpath(locator)));
    }

    public void waitElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    public void waitElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitListElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver,locator)));
    }

    public void waitElementPresent(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
    }

    public void waitListElementPresent(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(locator)));
    }

    private final int SHORT_TIMEOUT =10;
    private final int LONG_TIMEOUT = 30;

}


package ui.gofile;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.gofile.HomePageObject;

public class Level_13_Upload_File extends BaseTest {
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getPage(HomePageObject.class, driver);
    }

    @Test(enabled = true)
    public void Upload_01_Multiple() {
       Assert.assertTrue(homePage.isLoadingIconDisappear());
       homePage.sleepInSecond(2);


        homePage.uploadMultipleFiles(driver, anh1FileName,anh2FileName,anh3FileName,anh4FileName);

        Assert.assertTrue(homePage.isProgressBarIconDisappear());

        String successUrl = homePage.getSuccessLink();

        homePage.openPageUrl(driver, successUrl);

        Assert.assertTrue(homePage.isLoadingIconDisappear());



    }

    @AfterClass
    public void afterClass() {
        closeBrowser(driver);
    }


    private WebDriver driver;
    private HomePageObject homePage;
    private String anh1FileName = "Anh1.jpg";
    private String anh2FileName = "Anh2.jpg";
    private String anh3FileName = "Anh3.jpg";
    private String anh4FileName = "Anh4.jpg";

}

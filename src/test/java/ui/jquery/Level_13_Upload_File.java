package ui.jquery;


import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.jquery.HomePageObject;


public class Level_13_Upload_File extends BaseTest {

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getPage(HomePageObject.class, driver);
    }


    @Test(enabled = true)
    public void Upload_01_Single() {
        homePage.uploadMultipleFiles(driver, anh1FileName);
        homePage.uploadMultipleFiles(driver, anh2FileName);
        homePage.uploadMultipleFiles(driver, anh3FileName);
        homePage.uploadMultipleFiles(driver, anh1FileName);

        Assert.assertTrue(homePage.isFileLoadedByName(anh1FileName));
        Assert.assertTrue(homePage.isFileLoadedByName(anh2FileName));
        Assert.assertTrue(homePage.isFileLoadedByName(anh3FileName));
        Assert.assertTrue(homePage.isFileLoadedByName(anh1FileName));

        homePage.clickToStartButton();
        Assert.assertTrue(homePage.isFileUploadedByName(anh1FileName));

    }

    @Test(enabled = true)
    public void Upload_02_Multiple() {
        homePage.uploadMultipleFiles(driver, anh1FileName,anh2FileName,anh3FileName,anh4FileName);

        Assert.assertTrue(homePage.isFileLoadedByName(anh1FileName));
        Assert.assertTrue(homePage.isFileLoadedByName(anh2FileName));
        Assert.assertTrue(homePage.isFileLoadedByName(anh3FileName));
        Assert.assertTrue(homePage.isFileLoadedByName(anh1FileName));

        homePage.clickToStartButton();
        Assert.assertTrue(homePage.isFileUploadedByName(anh1FileName));
        Assert.assertTrue(homePage.isFileUploadedByName(anh2FileName));
        Assert.assertTrue(homePage.isFileUploadedByName(anh3FileName));
        Assert.assertTrue(homePage.isFileUploadedByName(anh4FileName));


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

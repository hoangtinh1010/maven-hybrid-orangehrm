package pageObjects.orangeHRM.EditNavigation;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.orangeHRM.EditNavigation.EditNavigatorPageUI;

public class EditNavigatorPageObject extends BasePage {
    private WebDriver driver;
    public EditNavigatorPageObject(WebDriver driver) {
        this.driver = driver;
    }
    // 9 Page (hàm) nằm trong Edit Employee Navigation
    public PersonalDetailPageObject openPersonalDetailPage() {
        waitElementClickable(driver, EditNavigatorPageUI.PERSONAL_DETAIL_LINK);
        clickToElement(driver, EditNavigatorPageUI.PERSONAL_DETAIL_LINK);
        return PageGenerator.getPage(PersonalDetailPageObject.class, driver);
    }

    public ContactDetailPageObject openContactDetailsPage() {
        waitElementClickable( driver, EditNavigatorPageUI.CONTACT_DETAIL_LINK);
        clickToElement( driver, EditNavigatorPageUI.CONTACT_DETAIL_LINK);
        return PageGenerator.getPage(ContactDetailPageObject.class, driver);
    }

    public EmergencyContactPageObject openEmergencyContactPage() {
        waitElementClickable( driver, EditNavigatorPageUI.EMERGENCY_CONTACT_LINK);
        clickToElement( driver, EditNavigatorPageUI.EMERGENCY_CONTACT_LINK);
        return PageGenerator.getPage(EmergencyContactPageObject.class, driver);
    }

    public DependentPageObject openDependentPage() {
        waitElementClickable( driver, EditNavigatorPageUI.DEPENDENT_LINK);
        clickToElement(driver, EditNavigatorPageUI.DEPENDENT_LINK);
        return PageGenerator.getPage(DependentPageObject.class,driver) ;
    }

    public ImmigrationPageObject openImmigrationPage() {
        waitElementClickable( driver, EditNavigatorPageUI.IMMIGRATION_LINK);
        clickToElement(driver, EditNavigatorPageUI.IMMIGRATION_LINK);
        return PageGenerator.getPage(ImmigrationPageObject.class,driver) ;
    }

    public JobPageObject openJobPage() {
        waitElementClickable(driver, EditNavigatorPageUI.JOB_LINK);
        clickToElement(driver, EditNavigatorPageUI.JOB_LINK);
        return PageGenerator.getPage(JobPageObject.class, driver);
    }    public SalaryPageObject openSalaryPage () {
        waitElementClickable(driver, EditNavigatorPageUI.SALARY_LINK);
        clickToElement(driver, EditNavigatorPageUI.SALARY_LINK);
        return PageGenerator.getPage(SalaryPageObject.class, driver);
    }

    public ReportToPageObject openReportToPage () {
        waitElementClickable(driver, EditNavigatorPageUI.REPORT_TO_LINK);
        clickToElement(driver, EditNavigatorPageUI.REPORT_TO_LINK);
        return PageGenerator.getPage(ReportToPageObject.class, driver);
    }  public QualificationPageObject openQualificationPage () {
        waitElementClickable(driver, EditNavigatorPageUI.QUALIFICATION_LINK);
        clickToElement(driver, EditNavigatorPageUI.QUALIFICATION_LINK);
        return PageGenerator.getPage(QualificationPageObject.class, driver);
    }
    public MembershipPageObject openMembershipPage () {
        waitElementClickable(driver, EditNavigatorPageUI.MEMBERSHIP_LINK);
        clickToElement(driver, EditNavigatorPageUI.MEMBERSHIP_LINK);
        return PageGenerator.getPage(MembershipPageObject.class, driver);
    }
}

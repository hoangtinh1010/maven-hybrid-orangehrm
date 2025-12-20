package javaSDET;

import org.testng.annotations.Test;

public class Topic_12_Dynamic_Locator {
    @Test
    public void testDynamicLocator() {
        // Page cụ thể: Personal Detail
        String personalDetailPage = "xpath=//a[text()='Personal Details']";
        String dependentPage = "xpath=//a[text()='Dependents']";
        String jobPage = "xpath=//a[text()='Job']";


        String dynamicPageOneParam = "//a[text()='%s']";
        String dynamicPageTwoParam = "//div[@class='orangehrm-%s-employee-navigation']//a[text()='%s']";
        String dynamicPageThreeParam = "//div[@class='orangehrm-%s-employee-navigation']//a[text()='%s' and @data-uid='%s']";

        // 1 - Mở trang cụ thể
        // Tái sử dụng hàm
        // Chưa tai sư dụng Locator
        openPageByName(personalDetailPage);
        openPageByName(dependentPage);
        openPageByName(jobPage);

        // 2 - Mở trang theo tên trang truyền vào (Re-useable )
        //Tham số truyền vào là tên trang
        openPageByName(dynamicPageOneParam, "Job");
        openPageByName(dynamicPageOneParam, "Personal Details");

        // 3 - Locator có nhiều hơn 1 tham số động can truyên vao
        openPageByName(dynamicPageTwoParam, "job", "Job");
        openPageByName(dynamicPageTwoParam, "contact", "Contact Details");
        openPageByName(dynamicPageTwoParam,"new", "News");

        // 4 - Locator có nhiều hơn 2 tham số động can truyên vao
        openPageByName(dynamicPageThreeParam, "job", "Job", "menu_employee_job_viewJobDetails");
        openPageByName(dynamicPageThreeParam, "contact", "Contact Details", "menu_employee_contactDetails");

    }

//    public void openPageByName(String pageLocator) {
//        System.out.println("Click to Page: " + pageLocator);
//        // Here you would add the code to interact with the web element using the dynamic locator
//    }
//
//    public void openPageByName(String pageLocator, String pageName) {
//        pageLocator = String.format(pageLocator, pageName);
//        System.out.println("Click to Page: " + pageLocator);
//    }
//
//    public void openPageByName(String pageLocator,String pageFunction, String pageName) {
//        System.out.println("Click to Page: " + String.format(pageLocator,pageFunction, pageName));
//    }
//
//    public void openPageByName(String pageLocator,String pageFunction, String pageName, String dataUID) {
//        System.out.println("Click to Page: " + String.format(pageLocator,pageFunction, pageName,dataUID));
//    }

    public void openPageByName(String pageLocator,String... restParams) {
        //Hàm này có thể thay thế cho 4 hàm trên
        System.out.println("Click to Page: " + String.format(pageLocator,(Object[]) restParams));
    }


}

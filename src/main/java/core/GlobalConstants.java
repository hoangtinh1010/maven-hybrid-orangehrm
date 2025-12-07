package core;

public class GlobalConstants {
    //System Info

    public static final String OS_NAME = System.getProperty("os.name");
    public static final String PROJECT_PATH = System.getProperty("user.name");

    //App Infor User
    public static final String DEV_USER_URL = "http://dev-user.orangehrmlive.com";
    public static final String STAGING_USER_URL = "http://staging-user.orangehrmlive.com";
    public static final String LIVE_USER_URL = "http://live-user.orangehrmlive.com";

    //App Infor Admin
    public static final String DEV_ADMIN_URL = "http://dev-admin.orangehrmlive.com";
    public static final String STAGING_ADMIN_URL = "http://staging-admin.orangehrmlive.com";
    public static final String LIVE_ADMIN_URL = "http://live-admin.orangehrmlive.com";

    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "admin123";

    //Wait Infor
    public static final int SHORT_TIMEOUT = 10;
    public static final int LONG_TIMEOUT = 30;

    //Download/Upload File
    public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + "/uploadFiles/";
    public static final String DOWNLOAD_PATH = PROJECT_PATH + "/downloadFiles/";

    //Retry Case Failed
    public static final int RETRY_NUMBER = 3;

    //Browser Logs/Extension
    public static final String BROWSER_LOG_PATH = PROJECT_PATH + "/browserLogs/";
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + "/browserExtensions/";

    //HTML Report Folder
    public static final String REPORTING_PATH = PROJECT_PATH + "/htmlReportNG/";
    public static final String EXTENT_PATH = PROJECT_PATH + "/htmlExtent/";
    public static final String ALLURE_PATH = PROJECT_PATH + "htmlAllure/";

    //Data test/Environment
    public static final String DATA_TESTING_PATH = PROJECT_PATH + "/dataTest/";
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + "/environmentConfig/";




}

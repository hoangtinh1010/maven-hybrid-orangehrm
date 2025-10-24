package pageObjects;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    //Hàm khởi tạo (Constructor Method)
    //Map driver từ Test Class vào trong Page Object Class
    public LoginPageObject(WebDriver driver) {
        //Trong truong hop 2 bien cung ten
        //1 bien la Global (this.driver) , 1 bien la Local (driver)
        this.driver = driver;
    }

    //Hảm khoi tạo này sẽ được chạy đầu tiên khi class này được gọi tới
    //Nếu không viết hàm khởi tạo thì trình biên dịch  sẽ tạo ra cho class một hàm khởi tạo mặc định rỗng (ko tham số)
    //Nếu viết thì nó s dùng hàm do mình define (User Defined Constructor)
    //cùng tên vs tên Class chứa nó
    //Không có giá trị trả về
    //Có 1 hoặc nhiều tham số / có 1 hoặc nhiều hàm khởi tạo
    // Thể hiện tính đa hình (Polymorphism) trong OOP


    public void enterToUsernameTextbox(String username) {
        //Ráp Action + UI với nhau
        waitElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, username);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton() {
        waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }
}

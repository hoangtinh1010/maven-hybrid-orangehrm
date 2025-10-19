package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_10 extends Topic_09{

    //Phạm vi toàn cục (Class)
    String address;
    public Topic_10(String name, String address) { //Phạm vi cục bo (hàm)
        super(name);
        this.address=address;
    }


}

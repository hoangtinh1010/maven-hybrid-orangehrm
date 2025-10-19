package javaSDET;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Topic_08 {
    WebDriver driver=null;

    //non-static
    String address ="";

    //Phạm vi static là chia se cho toàn bộ system sử dụng
    static String name ="Automation Testing";

    //HẰNG SỐ
    static final String AGE="18";
    public void TC_01() {
        //đối tợng là tp
        Topic_08 tp = new Topic_08();
        tp.address="";

        //Thuoc pham vi class
        Topic_08.name="Testing";

        // Topic_08.AGE="";

        String osName="Windows 11";
        String separator =null;

        //Condition Statement
        //if-else
        if (osName.contains("Windows")) {
            separator="\\";
        }
        else {
            separator="/";
        }

        String browserName = "chrome";
        //switch-case
        switch (browserName) {
            case "chrome":
                driver=new ChromeDriver();
                break;
            case "firefox":
               driver= new FirefoxDriver();
                break;
            case "edge":
                driver=new EdgeDriver();
                break;
            default:
                System.out.println("Browser name is not support/Please choose a valid browser!");
                break;
        }

        //Loop Statement

        //for
        //Classic For/Interation For
        int studentNubmer=10;
        for (int i = 0; i < studentNubmer; i++) {
            System.out.println("Student number: " + i);
        }

        for (int i = 0; i < studentNubmer; i++) {
            if (i==5){
            System.out.println("Student number: " + i);
        }}

        //For -Each
        List<String> stdName=new ArrayList<String>();
        for (String name: stdName) {
            System.out.println("Student name: " + name);
        }
        //while
        int x=0;
        while (x<studentNubmer) {
            System.out.println(x);
            x++;
        }
        //do-white
        int z=10;
        do{
            System.out.println(z);
            z++;
        }while (z<studentNubmer);

//       //ếu như element không đuợc tìm thấy thì cũng ko bị lôi
        try {
            //Happy Case
            driver.findElement(By.cssSelector("")).isDisplayed();
        }catch (NoSuchElementException exception){
            //Edge Case
            System.out.println("Element is not found");
        } finally {
            //Close connection: DB/File/..
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

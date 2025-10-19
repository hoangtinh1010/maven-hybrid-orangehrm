package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Class kế thuwaf Class: extend
//Class kế thừa interface: implements
//Class con phải override tất cả các phương thức abstract của lớp cha và interface
public class Topic_01_Keywords extends Topic_06 implements Topic_02 {
    //Type
    byte bNumber=10;
    short sNumber=100;
    int iNumber=1000;
    long lNumber=10000L;
    float fNumber=10.5f;
    double dNumber=20.99;
    char cCharacter='A';
    boolean bStatus=true;
    String fullName= null;

    //AccessModifier
    //Variable
    public String studentName="John Doe";
    private int studentAge=20;
    protected String studentAddress="123 Main St";
    String studentPhone="0123456789";

    //Method
    //Khoong có kiểu trả về (void)
    private void TC_01() {
        WebDriver driver = new FirefoxDriver();

        Topic_01_Keywords topic = new Topic_01_Keywords();

    }

    void TC_02() {

    }
    protected void TC_03() {

    }

    public void TC_04() {

    }

    //Class/Enum/Interface/Annotation/Record




    @Override
    public void clearStudent() {
        System.out.println("This is the implementation of the abstract method from the interface.");
    }

}

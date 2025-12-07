package javaSDET;

public class Topic_11_String {
    public static void main(String[] args) {
        String locator="id = username";
        String[] locatorArr = locator.split("=");
        System.out.println(locatorArr[0].trim());
        System.out.println(locatorArr[1])  ;
        System.out.println(locatorArr[1].trim());
        System.out.println(locator.substring(1));

    }


}

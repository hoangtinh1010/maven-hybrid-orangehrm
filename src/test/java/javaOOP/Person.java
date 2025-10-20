package javaOOP;

public class Person {
    //Thuôc tính/Biến/ Variable
    String fullName;
    int age;
    String address;

    //Phương thức/Hàm/Method

    public Person (String fullName, int age, String address) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
    }
    public void setFullname(String name) {
        this.fullName = name;
    }

    public String getFullname() {
        return this.fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }
}

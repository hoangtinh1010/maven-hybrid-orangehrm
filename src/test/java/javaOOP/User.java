package javaOOP;

public class User {
    public static void main(String[] args) {
        // Final ko kế thừa được nhưng khởi tạo được
        // Object /Instance
        Car car = new Car();
        car.setFullname();
        car.fullName = "Honda Civic";

        Car car2 = new Car();

        //Khởi tạo
        Computer computer = new Computer();
        computer.setRam();

        //Person
        Person person1 = new Person("Nguyen Van A", 30, "Ha Noi");
        Person person2 = new Person("Tran Thi B", 25, "Hai Phong");

    }
}

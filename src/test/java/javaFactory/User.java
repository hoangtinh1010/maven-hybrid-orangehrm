package javaFactory;

public class User {
    public static void main(String[] args) {
    //Car factory
        Car car = null;
        //Morning
        car= getCar("Ford");
        car.viewCar();
        car.driveCar();
        //Afternoon
        car= getCar("Toyota");
        car.viewCar();
        car.driveCar();

        //Evening
        car= getCar("Hyundai");
        car.viewCar();
        car.driveCar();
    }

    public static Car getCar(String carName) {
        Car car = null;
        switch (carName) {
            case "Ford":
                car = new Ford();
                break;
            case "Toyota":
                car = new Toyota();
                break;
            case "Hyundai":
                car = new Hyundai();
                break;
            default:
                System.out.println("Car brand not recognized.");
        }
        return car;
    }
}

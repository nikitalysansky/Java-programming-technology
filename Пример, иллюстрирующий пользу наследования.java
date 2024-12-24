// Родительский класс
class Vehicle {
    protected String make;
    protected String model;

    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void startEngine() {
        System.out.println("Двигатель включен");
    }

    public void stopEngine() {
        System.out.println("Двигатель выключен");
    }
}

// Дочерний класс
class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String make, String model, int numberOfDoors) {
        super(make, model);
        this.numberOfDoors = numberOfDoors;
    }

    public void openTrunk() {
        System.out.println("Багажник открыт");
    }
}

// Дочерний класс
class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model) {
        super(make, model);
    }

    public void doWheelie() {
        System.out.println("Мотоцикл на заднем колесе!");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 4);
        car.startEngine();
        car.openTrunk();

        Motorcycle motorcycle = new Motorcycle("Yamaha", "YZF-R3");
        motorcycle.startEngine();
        motorcycle.doWheelie();
    }
}

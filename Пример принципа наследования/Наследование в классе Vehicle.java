// Родительский класс
public class Vehicle {
    protected String brand; // Поле, доступное наследникам

    public Vehicle(String brand) {
        this.brand = brand;
    }

    // Метод, общий для всех транспортных средств
    public void startEngine() {
        System.out.println(brand + " engine is starting...");
    }

    public void stopEngine() {
        System.out.println(brand + " engine is stopping...");
    }
}

class Boat extends Car {
    public Boat(String make, String model) {
        super(make, model, 0); // У лодки нет дверей, но код требует этот параметр
    }

    public void sail() {
        System.out.println("Лодка плывет");
    }
}

public class Main {
    public static void main(String[] args) {
        Boat boat = new Boat("Yamaha", "FX Cruiser");
        boat.startEngine();
        boat.sail();
        boat.openTrunk(); // Что? У лодки есть багажник? Это ошибка
    }
}

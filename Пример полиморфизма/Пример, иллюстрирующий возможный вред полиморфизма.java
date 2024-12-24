class Ellipse extends Shape {
    private double a; // Большая полуось
    private double b; // Малая полуось

    public Ellipse(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea() {
        return (a + b) * 2; // Ошибка! Формула неверная
    }
}

public class Main {
    public static void main(String[] args) {
        Shape ellipse = new Ellipse(4, 2);
        System.out.println("Площадь эллипса: " + ellipse.getArea()); // Результат неверный
    }
}

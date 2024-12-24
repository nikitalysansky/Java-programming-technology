// Базовый класс
abstract class Shape {
    // Абстрактный метод для вычисления площади
    public abstract double getArea();
}

// Класс для круга
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Класс для прямоугольника
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

// Класс для треугольника
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем массив фигур
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 4)
        };

        // Используем полиморфизм для вычисления площади всех фигур
        for (Shape shape : shapes) {
            System.out.println("Площадь фигуры: " + shape.getArea());
        }
    }
}

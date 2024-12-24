import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите год для проверки:");

        try {
            // Считывание ввода пользователя
            String input = scanner.nextLine();

            // Попытка преобразования строки в целое число
            int year = Integer.parseInt(input);

            // Проверка, является ли год високосным
            if (isLeapYear(year)) {
                System.out.println(year + " является високосным годом.");
            } else {
                System.out.println(year + " не является високосным годом.");
            }
        } catch (NumberFormatException e) {
            // Обработка исключения, если ввод не является числом
            System.out.println("Ошибка: введенные данные не являются числом. Пожалуйста, введите корректный год.");
        } finally {
            scanner.close();
        }
    }

    // Метод для проверки, является ли год високосным
    public static boolean isLeapYear(int year) {
        // Год високосный, если он делится на 4 и (не делится на 100 или делится на 400)
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

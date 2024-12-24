import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение (например, 2 + 3 или 4.5 * 6):");
        String input = scanner.nextLine();

        try {
            double result = calculate(input);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }

    private static double calculate(String input) {
        // Убираем пробелы, чтобы облегчить разбор
        input = input.replaceAll("\\s+", "");

        // Поиск оператора
        char operator = 0;
        int operatorIndex = -1;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operator = c;
                operatorIndex = i;
                break;
            }
        }

        // Если оператор не найден, бросаем исключение
        if (operatorIndex == -1) {
            throw new IllegalArgumentException("Выражение должно содержать оператор (+, -, *, /).");
        }

        // Разделяем строку на операнды
        String leftOperand = input.substring(0, operatorIndex);
        String rightOperand = input.substring(operatorIndex + 1);

        // Преобразуем операнды в числа
        double num1;
        double num2;
        try {
            num1 = Double.parseDouble(leftOperand);
            num2 = Double.parseDouble(rightOperand);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректные операнды. Убедитесь, что вводите числа.");
        }

        // Выполняем операцию
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("Деление на ноль невозможно.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Неизвестный оператор: " + operator);
        }
    }
}

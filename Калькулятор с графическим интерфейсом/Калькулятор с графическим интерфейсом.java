import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display; // Поле для отображения ввода/результата
    private double num1 = 0;    // Первое число
    private double num2 = 0;    // Второе число
    private String operator = ""; // Текущий оператор

    public Calculator() {
        // Настройка окна
        setTitle("Калькулятор");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Создание поля ввода/отображения
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // Создание панели для кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        // Кнопки калькулятора
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        // Добавление кнопок
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "C": // Очистка
                display.setText("");
                num1 = 0;
                num2 = 0;
                operator = "";
                break;

            case "=": // Вычисление результата
                try {
                    num2 = Double.parseDouble(display.getText());
                    double result = calculate(num1, num2, operator);
                    display.setText(String.valueOf(result));
                    num1 = result; // Сохраняем результат для последующих операций
                } catch (NumberFormatException ex) {
                    display.setText("Ошибка");
                }
                break;

            case "+": case "-": case "*": case "/": // Операторы
                try {
                    num1 = Double.parseDouble(display.getText());
                    operator = command;
                    display.setText(""); // Очистка для второго числа
                } catch (NumberFormatException ex) {
                    display.setText("Ошибка");
                }
                break;

            default: // Числа
                display.setText(display.getText() + command);
        }
    }

    // Метод для выполнения арифметической операции
    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                return num1 / num2;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}

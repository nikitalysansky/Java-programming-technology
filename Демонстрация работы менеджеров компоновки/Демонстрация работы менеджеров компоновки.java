import javax.swing.*;
import java.awt.*;

public class LayoutDemo extends JFrame {

    public LayoutDemo() {
        // Настройка главного окна
        setTitle("Демонстрация менеджеров компоновки");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Установка BorderLayout для JFrame
        setLayout(new BorderLayout());

        // Добавление кнопок на BorderLayout
        add(new JButton("Север"), BorderLayout.NORTH);
        add(new JButton("Юг"), BorderLayout.SOUTH);
        add(new JButton("Запад"), BorderLayout.WEST);
        add(new JButton("Восток"), BorderLayout.EAST);

        // Создание центральной панели с FlowLayout
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());

        // Добавление кнопок на JPanel с FlowLayout
        for (int i = 1; i <= 5; i++) {
            centerPanel.add(new JButton("Кнопка " + i));
        }

        // Добавление панели в центр JFrame
        add(centerPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LayoutDemo frame = new LayoutDemo();
            frame.setVisible(true);
        });
    }
}

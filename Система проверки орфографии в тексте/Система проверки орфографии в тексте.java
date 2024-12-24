import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class SpellCheckEditor extends JFrame {
    private JTextArea textArea;
    private Map<String, String> dictionary;

    public SpellCheckEditor() {
        // Настройка окна
        setTitle("Текстовый редактор с проверкой орфографии");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Создание текстовой области
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Загрузка словаря
        loadDictionary();

        // Добавление обработчика нажатий клавиш
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == ' ') {
                    // При нажатии пробела запускается проверка орфографии в отдельном потоке
                    new Thread(SpellCheckEditor.this::checkSpelling).start();
                }
            }
        });
    }

    private void loadDictionary() {
        // Загрузка простого словаря с неправильными и правильными словами
        dictionary = new HashMap<>();
        dictionary.put("teh", "the");
        dictionary.put("recieve", "receive");
        dictionary.put("adres", "address");
        dictionary.put("langauge", "language");
        dictionary.put("speling", "spelling");
    }

    private void checkSpelling() {
        // Получение текста из текстовой области
        String text = textArea.getText();

        // Разделение текста на слова
        String[] words = text.split("\\s+");

        // Создание нового текста с исправлениями
        StringBuilder correctedText = new StringBuilder();

        for (String word : words) {
            String trimmedWord = word.trim(); // Удаляем пробелы
            String correctedWord = dictionary.getOrDefault(trimmedWord, trimmedWord); // Заменяем слово, если оно есть в словаре
            correctedText.append(correctedWord).append(" ");
        }

        // Обновление текста в текстовой области (выполняется в EDT)
        SwingUtilities.invokeLater(() -> textArea.setText(correctedText.toString().trim()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SpellCheckEditor editor = new SpellCheckEditor();
            editor.setVisible(true);
        });
    }
}

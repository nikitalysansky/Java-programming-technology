import java.io.*;
import java.util.*;

public class FileCompression {

    public static void main(String[] args) {
        String inputFile = "input.txt";     // Исходный файл
        String compressedFile = "compressed.txt"; // Сжатый файл
        String restoredFile = "restored.txt";     // Восстановленный файл

        try {
            System.out.println("Сжимаем файл...");
            compressFile(inputFile, compressedFile);

            System.out.println("Восстанавливаем файл...");
            restoreFile(compressedFile, restoredFile);

            System.out.println("Операции завершены. Проверьте файлы: " + compressedFile + " и " + restoredFile);
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    // Метод для сжатия файла: удаление дубликатов строк и запись количества
    public static void compressFile(String inputFile, String outputFile) throws IOException {
        Map<String, Integer> lineCounts = new LinkedHashMap<>();

        // Чтение файла и подсчет строк
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCounts.put(line, lineCounts.getOrDefault(line, 0) + 1);
            }
        }

        // Запись сжатого файла
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, Integer> entry : lineCounts.entrySet()) {
                writer.write(entry.getKey());
                if (entry.getValue() > 1) {
                    writer.write(" [x" + entry.getValue() + "]");
                }
                writer.newLine();
            }
        }

        System.out.println("Файл сжат и сохранен как: " + outputFile);
    }

    // Метод для восстановления исходного файла из сжатой версии
    public static void restoreFile(String inputFile, String outputFile) throws IOException {
        List<String> restoredLines = new ArrayList<>();

        // Чтение сжатого файла
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int count = 1; // По умолчанию строка появляется один раз

                // Проверка наличия отметки количества
                if (line.contains(" [x")) {
                    int startIndex = line.lastIndexOf(" [x") + 3;
                    int endIndex = line.lastIndexOf("]");
                    count = Integer.parseInt(line.substring(startIndex, endIndex));
                    line = line.substring(0, line.lastIndexOf(" [x")); // Убираем метку
                }

                // Добавляем строку `count` раз в список
                for (int i = 0; i < count; i++) {
                    restoredLines.add(line);
                }
            }
        }

        // Запись восстановленного файла
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String restoredLine : restoredLines) {
                writer.write(restoredLine);
                writer.newLine();
            }
        }

        System.out.println("Файл восстановлен и сохранен как: " + outputFile);
    }
}

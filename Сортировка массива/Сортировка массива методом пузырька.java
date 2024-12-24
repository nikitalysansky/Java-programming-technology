import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        // Пример массива для сортировки
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(array));

        bubbleSort(array);

        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(array));
    }

    // Метод для сортировки массива пузырьком
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Для отслеживания обменов в текущем проходе
            for (int j = 0; j < n - i - 1; j++) {
                // Если текущий элемент больше следующего, меняем их местами
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            // Если не было обменов, массив уже отсортирован
            if (!swapped) {
                break;
            }
        }
    }
}

import java.util.Scanner;

public class CompoundInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите действие:");
        System.out.println("1. Вычислить итоговую сумму с учетом сложного процента.");
        System.out.println("2. Вычислить процентную ставку для достижения суммы.");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                calculateCompoundInterest(scanner);
                break;
            case 2:
                calculateRequiredRate(scanner);
                break;
            default:
                System.out.println("Некорректный выбор.");
        }

        scanner.close();
    }

    private static void calculateCompoundInterest(Scanner scanner) {
        System.out.print("Введите начальную сумму: ");
        double principal = scanner.nextDouble();

        System.out.print("Введите процентную ставку (в процентах): ");
        double rate = scanner.nextDouble();

        System.out.print("Введите количество периодов: ");
        int periods = scanner.nextInt();

        // Вычисление итоговой суммы
        double finalAmount = principal * Math.pow(1 + rate / 100, periods);
        System.out.printf("Итоговая сумма: %.2f\n", finalAmount);
    }

    private static void calculateRequiredRate(Scanner scanner) {
        System.out.print("Введите начальную сумму: ");
        double principal = scanner.nextDouble();

        System.out.print("Введите желаемую сумму: ");
        double finalAmount = scanner.nextDouble();

        System.out.print("Введите количество периодов: ");
        int periods = scanner.nextInt();

        // Вычисление процентной ставки
        if (principal <= 0 || finalAmount <= 0 || periods <= 0) {
            System.out.println("Суммы и периоды должны быть положительными числами.");
            return;
        }

        double rate = (Math.pow(finalAmount / principal, 1.0 / periods) - 1) * 100;
        System.out.printf("Необходимая процентная ставка: %.2f%%\n", rate);
    }
}

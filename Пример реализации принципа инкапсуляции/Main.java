public class Main {
    public static void main(String[] args) {
        // Создание объекта BankAccount
        BankAccount account = new BankAccount("John Doe", 500.0);

        // Доступ к данным через методы
        account.deposit(200.0);
        account.withdraw(100.0);

        // Попытка снять больше, чем доступно
        account.withdraw(1000.0);

        // Изменение имени владельца
        account.setAccountHolderName("Jane Doe");

        // Отображение информации
        account.displayAccountInfo();
    }
}

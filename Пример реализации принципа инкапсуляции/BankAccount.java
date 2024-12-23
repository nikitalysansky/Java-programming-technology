public class BankAccount {
    // Закрытые поля (private) для инкапсуляции данных
    private String accountHolderName;
    private double balance;

    // Конструктор для инициализации объекта
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Setting to 0.");
        }
    }

    // Публичные методы для доступа к закрытым полям (геттеры и сеттеры)
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Метод для внесения средств
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Метод для снятия средств
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Метод для отображения текущего состояния счета
    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }
}

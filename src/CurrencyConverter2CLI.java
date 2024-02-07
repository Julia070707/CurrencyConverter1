import java.util.Scanner;

public class CurrencyConverter2CLI {
    private Scanner scanner;
    private CurrencyConverter2 currencyConverter;

    public CurrencyConverter2CLI() {
        this.scanner = new Scanner(System.in);
        this.currencyConverter = new CurrencyConverter2();
    }

    public void run() {
        System.out.println("Приветствуем в CurrencyConverter!\n");

        do {
            System.out.println("Выберите исходную валюту:");
            displayCurrencyOptions();

            int sourceCurrencyIndex = getUserChoice();
            if (sourceCurrencyIndex == -1) {
                break;
            }

            System.out.println("Выберите конечную валюту:");
            displayCurrencyOptions();

            int targetCurrencyIndex = getUserChoice();
            if (targetCurrencyIndex == -1) {
                break;
            }

            System.out.print("Введите сумму для конвертации: ");
            double amount = scanner.nextDouble();

            double result = currencyConverter.convertCurrency(amount, sourceCurrencyIndex, targetCurrencyIndex);

            System.out.println("Результат конвертации: " + result + " " +
                    currencyConverter.getAvailableCurrencies()[targetCurrencyIndex]);

            scanner.nextLine(); // Consume the newline character
        } while (true);

        System.out.println("Программа завершена.");
    }

    private void displayCurrencyOptions() {
        String[] currencies = currencyConverter.getAvailableCurrencies();
        System.out.println("Доступные валюты:");
        for (int i = 0; i < currencies.length; i++) {
            System.out.println((i + 1) + "." + currencies[i]);
        }
    }

    private int getUserChoice() {
        System.out.print("Выберите валюту (введите номер или 'exit'): ");
        String userInput = scanner.nextLine().toLowerCase();

        if (userInput.equals("exit")) {
            return -1; // Сигнал для выхода из программы
        }

        try {
            int choice = Integer.parseInt(userInput);
            if (choice >= 1 && choice <= currencyConverter.getAvailableCurrencies().length) {
                return choice - 1; // Возвращаем индекс в массиве курсов обмена
            } else {
                System.out.println("Некорректный выбор. Пожалуйста, выберите число от 1 до " +
                        currencyConverter.getAvailableCurrencies().length + ".");
                return getUserChoice();
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод. Пожалуйста, выберите число от 1 до " +
                    currencyConverter.getAvailableCurrencies().length + " или введите 'exit'.");
            return getUserChoice();
        }
    }

    public static void main(String[] args) {
        CurrencyConverter2CLI converterCLI = new CurrencyConverter2CLI();
        converterCLI.run();
    }
}

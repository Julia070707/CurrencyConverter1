import java.util.Scanner;

class CurrencyConverter {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                // Массивы для хранения курсов валют и их символов
                String[] currencies = {"1.USD", "2.EUR", "3.TL"};
                double[] exchangeRates = {1.0, 0.85, 11.0}; // Порядок: 1.USD, 2.EUR, 3.TL

                // Вызываем метод приветствия и вывода списка валют перед циклом
                приветствиеИСписокВалют(currencies);

                do {
                        System.out.println("Выберите исходную валюту:");
                        displayCurrencyOptions(currencies);

                        int sourceCurrencyIndex = getUserChoice(currencies.length);
                        if (sourceCurrencyIndex == -1) {
                                break; // Выход из программы, если пользователь ввел "exit"
                        }

                        System.out.println("Выберите конечную валюту:");
                        displayCurrencyOptions(currencies);

                        int targetCurrencyIndex = getUserChoice(currencies.length);
                        if (targetCurrencyIndex == -1) {
                                break; // Выход из программы, если пользователь ввел "exit"
                        }

                        System.out.print("Введите сумму для конвертации: ");
                        double amount = scanner.nextDouble();

                        double result = convertCurrency(amount, exchangeRates[sourceCurrencyIndex], exchangeRates[targetCurrencyIndex]);

                        System.out.println("Результат конвертации: " + result + " " + currencies[targetCurrencyIndex]);
                        scanner.nextLine(); // Consume the newline character
                } while (true);

                System.out.println("Программа завершена.");
        }

        // Новый метод для вывода приветственного сообщения и списка валют
        private static void приветствиеИСписокВалют(String[] currencies) {
                System.out.println("Приветствуем в CurrencyConverter!\n");
                displayCurrencyOptions(currencies);
        }

        // Остальные методы остались без изменений
        private static void displayCurrencyOptions(String[] currencies) {
                // Использование for-each для вывода списка доступных валют
                System.out.println("Доступные валюты:");
                for (String currency : currencies) {
                        System.out.print(currency + " ");
                }
                System.out.println();
        }

        private static int getUserChoice(int numberOfCurrencies) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Выберите валюту (введите номер или 'exit'): ");
                String userInput = scanner.nextLine().toLowerCase();

                if (userInput.equals("exit")) {
                        return -1; // Сигнал для выхода из программы
                }

                try {
                        int choice = Integer.parseInt(userInput);
                        if (choice >= 1 && choice <= numberOfCurrencies) {
                                return choice - 1; // Возвращаем индекс в массиве курсов обмена
                        } else {
                                System.out.println("Некорректный выбор. Пожалуйста, выберите число от 1 до " + numberOfCurrencies + ".");
                                return getUserChoice(numberOfCurrencies);
                        }
                } catch (NumberFormatException e) {
                        System.out.println("Некорректный ввод. Пожалуйста, выберите число от 1 до " + numberOfCurrencies + " или введите 'exit'.");
                        return getUserChoice(numberOfCurrencies);
                }
        }

        private static double convertCurrency(double amount, double sourceRate, double targetRate) {
                return amount * targetRate / sourceRate;
        }
}
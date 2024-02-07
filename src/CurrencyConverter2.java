import java.util.Arrays;

public class CurrencyConverter2 {
    private double[] currencyRates;
    private String[] availableCurrencies;

    // Пустой конструктор
    public CurrencyConverter2() {
        // Значения по умолчанию
        this.currencyRates = new double[]{1.0, 0.85, 11.0};
        this.availableCurrencies = new String[]{"USD", "EUR", "TL"};
    }

    // Конструктор с заданными курсами валют
    public CurrencyConverter2(double[] currencyRates) {
        this.currencyRates = Arrays.copyOf(currencyRates, currencyRates.length);
        this.availableCurrencies = new String[]{"USD", "EUR", "TL"}; // Значения по умолчанию
    }

    // Полный конструктор
    public CurrencyConverter2(double[] currencyRates, String[] availableCurrencies) {
        this.currencyRates = Arrays.copyOf(currencyRates, currencyRates.length);
        this.availableCurrencies = Arrays.copyOf(availableCurrencies, availableCurrencies.length);
    }

    // Метод для конвертации валюты
    public double convertCurrency(double amount, int sourceCurrencyIndex, int targetCurrencyIndex) {
        return amount * currencyRates[targetCurrencyIndex] / currencyRates[sourceCurrencyIndex];
    }

    // Геттер для доступа к доступным валютам
    public String[] getAvailableCurrencies() {
        return Arrays.copyOf(availableCurrencies, availableCurrencies.length);
    }
}

package main.java;

public class CurrencyConverter {
    private static final double[] rates = {1.0, 1.1, 1.25, 0.009}; ///// USD, EUR, GBP, JPY

    public static double convertCurrency(double amount, int source, int target) {
        if (source < 1 || source > 4 || target < 1 || target > 4) {
            throw new IllegalArgumentException("Некорректный индекс валюты");
        }
        return amount * rates[source - 1] / rates[target - 1];
    }
}

package main.java;

public class LengthConverter {
    private static final double[] factors = {1, 0.1, 0.01, 0.001, 0.000001}; // mmmmmm, cm, dm, m, km

    public static double convertLength(double value, int source, int target) {
        if (source < 1 || source > 5 || target < 1 || target > 5) {
            throw new IllegalArgumentException("Некорректный индекс единицы измерения");
        }
        return value * factors[source - 1] / factors[target - 1];
    }
}

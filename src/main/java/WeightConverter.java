package main.java;

public class WeightConverter {
    private static final double[] factors = {1, 1000, 1000000, 100000000, 1000000000}; // mg, g, kg, c, t

    public static double convertWeight(double value, int source, int target) {
        if (source < 1 || source > 5 || target < 1 || target > 5) {
            throw new IllegalArgumentException("Некорректный индекс единицы измерения");
        }
        return value * factors[source - 1] / factors[target - 1];
    }
}

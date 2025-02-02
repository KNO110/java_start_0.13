import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите задание:\n1. Геометрические фигуры (площадь)\n2. Конвертация валют\n3. Работа со строками\n4. Перевод значений длины\n5. Перевод значений веса");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: task1(); break;
            case 2: task2(); break;
            case 3: task3(); break;
            case 4: task4(); break;
            case 5: task5(); break;
            default: System.out.println("Неверный выбор"); break;
        }
    }
    public static void task1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите фигуру:\n1. Треугольник\n2. Прямоугольник\n3. Квадрат\n4. Ромб");
        int figure = sc.nextInt();
        double area = 0;
        switch (figure) {
            case 1:
                System.out.println("Введите основание треугольника:");
                double base = sc.nextDouble();
                System.out.println("Введите высоту треугольника:");
                double height = sc.nextDouble();
                area = areaTriangle(base, height);
                break;
            case 2:
                System.out.println("Введите длину прямоугольника:");
                double a = sc.nextDouble();
                System.out.println("Введите ширину прямоугольника:");
                double b = sc.nextDouble();
                area = areaRectangle(a, b);
                break;
            case 3:
                System.out.println("Введите сторону квадрата:");
                double side = sc.nextDouble();
                area = areaSquare(side);
                break;
            case 4:
                System.out.println("Введите первую диагональ ромба:");
                double d1 = sc.nextDouble();
                System.out.println("Введите вторую диагональ ромба:");
                double d2 = sc.nextDouble();
                area = areaRhombus(d1, d2);
                break;
            default:
                System.out.println("Неверный выбор фигуры");
                return;
        }
        System.out.println("Площадь фигуры: " + area);
    }
    public static double areaTriangle(double base, double height) {
        return 0.5 * base * height;
    }
    public static double areaRectangle(double a, double b) {
        return a * b;
    }
    public static double areaSquare(double side) {
        return side * side;
    }
    public static double areaRhombus(double d1, double d2) {
        return 0.5 * d1 * d2;
    }
    public static void task2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите исходную валюту:\n1. Доллар\n2. Евро\n3. Фунт стерлингов\n4. Яна");
        int source = sc.nextInt();
        System.out.println("Выберите целевую валюту:\n1. Доллар\n2. Евро\n3. Фунт стерлингов\n4. Яна");
        int target = sc.nextInt();
        System.out.println("Введите сумму для конвертации:");
        double amount = sc.nextDouble();
        double result = convertCurrency(amount, source, target);
        System.out.println("Конвертированная сумма: " + result);
    }
    public static double convertCurrency(double amount, int source, int target) {
        double[] rates = {0, 1.0, 1.1, 1.25, 0.009};
        return amount * rates[source] / rates[target];
    }
    public static void task3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите операцию со строкой:\n1. Проверка на палиндром\n2. Подсчет количества гласных\n3. Подсчет количества согласных\n4. Подсчет количества вхождений слова");
        int op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                System.out.println("Введите строку для проверки на палиндром:");
                String s = sc.nextLine();
                boolean isPal = isPalindrome(s);
                System.out.println("Строка " + (isPal ? "является" : "не является") + " палиндромом");
                break;
            case 2:
                System.out.println("Введите строку для подсчета гласных:");
                String s2 = sc.nextLine();
                int vowels = countVowels(s2);
                System.out.println("Количество гласных: " + vowels);
                break;
            case 3:
                System.out.println("Введите строку для подсчета согласных:");
                String s3 = sc.nextLine();
                int cons = countConsonants(s3);
                System.out.println("Количество согласных: " + cons);
                break;
            case 4:
                System.out.println("Введите основную строку:");
                String text = sc.nextLine();
                System.out.println("Введите слово для поиска:");
                String word = sc.nextLine();
                int count = countWordOccurrences(text, word);
                System.out.println("Количество вхождений слова: " + count);
                break;
            default:
                System.out.println("Неверный выбор операции");
                break;
        }
    }
    public static boolean isPalindrome(String s) {
        String clean = s.replaceAll("\\s+", "").toLowerCase();
        return clean.equals(new StringBuilder(clean).reverse().toString());
    }
    public static int countVowels(String s) {
        int count = 0;
        String vowels = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
        for (int i = 0; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) count++;
        }
        return count;
    }
    public static int countConsonants(String s) {
        int count = 0;
        String letters = "бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ";
        for (int i = 0; i < s.length(); i++) {
            if (letters.indexOf(s.charAt(i)) != -1) count++;
        }
        return count;
    }
    public static int countWordOccurrences(String text, String word) {
        int count = 0, index = 0;
        while ((index = text.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
    public static void task4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите исходную единицу длины:\n1. Милиметры\n2. Сантиметры\n3. Дециметры\n4. Метры\n5. Километры");
        int source = sc.nextInt();
        System.out.println("Выберите целевую единицу длины:\n1. Милиметры\n2. Сантиметры\n3. Дециметры\n4. Метры\n5. Километры");
        int target = sc.nextInt();
        System.out.println("Введите значение для конвертации:");
        double value = sc.nextDouble();
        double result = convertLength(value, source, target);
        System.out.println("Конвертированное значение: " + result);
    }
    public static double convertLength(double value, int source, int target) {
        double[] factors = {0, 0.001, 0.01, 0.1, 1, 1000};
        return value * factors[source] / factors[target];
    }
    public static void task5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите исходную единицу веса:\n1. Милиграммы\n2. Граммы\n3. Килограммы\n4. Центнеры\n5. Тонны");
        int source = sc.nextInt();
        System.out.println("Выберите целевую единицу веса:\n1. Милиграммы\n2. Граммы\n3. Килограммы\n4. Центнеры\n5. Тонны");
        int target = sc.nextInt();
        System.out.println("Введите значение для конвертации:");
        double value = sc.nextDouble();
        double result = convertWeight(value, source, target);
        System.out.println("Конвертированное значение: " + result);
    }
    public static double convertWeight(double value, int source, int target) {
        double[] factors = {0, 0.001, 1, 1000, 100000, 1000000};
        return value * factors[source] / factors[target];
    }
    public static class GeometryTests {
        @Test
        public void testTriangle() {
            assertEquals(10.0, areaTriangle(4, 5), 0.001);
        }
        @Test
        public void testRectangle() {
            assertEquals(20.0, areaRectangle(4, 5), 0.001);
        }
        @Test
        public void testSquare() {
            assertEquals(16.0, areaSquare(4), 0.001);
        }
        @Test
        public void testRhombus() {
            assertEquals(10.0, areaRhombus(4, 5), 0.001);
        }
    }
    public static class CurrencyTests {
        @Test
        public void testConvertCurrency() {
            assertEquals(100.0, convertCurrency(100, 1, 1), 0.001);
            double res = convertCurrency(100, 1, 2);
            assertEquals(100 * 1.0 / 1.1, res, 0.001);
        }
    }
    public static class StringTests {
        @Test
        public void testPalindrome() {
            assertTrue(isPalindrome("йоу"));
            assertFalse(isPalindrome("ку"));
        }
        @Test
        public void testCountVowels() {
            assertEquals(1, countVowels("тест"));
        }
        @Test
        public void testCountConsonants() {
            assertEquals(3, countConsonants("тест"));
        }
        @Test
        public void testCountWordOccurrences() {
            assertEquals(2, countWordOccurrences("привет мир привет", "привет"));
        }
    }
    public static class LengthTests {
        @Test
        public void testConvertLength() {
            double res = convertLength(1000, 1, 4);
            assertEquals(1.0, res, 0.001);
        }
    }
    public static class WeightTests {
        @Test
        public void testConvertWeight() {
            double res = convertWeight(1000000000, 1, 5);
            assertEquals(1.0, res, 0.001);
        }
    }
}

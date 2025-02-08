package main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nВыберите задание:");
            System.out.println("1. Геометрические фигуры (площадь)");
            System.out.println("2. Конвертация валют");
            System.out.println("3. Работа со строками");
            System.out.println("4. Перевод значений длины");
            System.out.println("5. Перевод значений веса");
            System.out.println("0. Выход");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> task1();
                case 2 -> task2();
                case 3 -> task3();
                case 4 -> task4();
                case 5 -> task5();
                case 0 -> {
                    System.out.println("Выход...");
                    return;
                }
                default -> System.out.println("Неверный выбор");
            }
        }
    }

    public static void task1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите фигуру:");
        System.out.println("1. Треугольник\n2. Прямоугольник\n3. Квадрат\n4. Ромб");
        int figure = sc.nextInt();

        double area = switch (figure) {
            case 1 -> {
                System.out.println("Введите основание и высоту треугольника:");
                yield Geometry.areaTriangle(sc.nextDouble(), sc.nextDouble());
            }
            case 2 -> {
                System.out.println("Введите длину и ширину прямоугольника:");
                yield Geometry.areaRectangle(sc.nextDouble(), sc.nextDouble());
            }
            case 3 -> {
                System.out.println("Введите сторону квадрата:");
                yield Geometry.areaSquare(sc.nextDouble());
            }
            case 4 -> {
                System.out.println("Введите две диагонали ромба:");
                yield Geometry.areaRhombus(sc.nextDouble(), sc.nextDouble());
            }
            default -> {
                System.out.println("Неверный выбор фигуры");
                yield -1;
            }
        };

        if (area >= 0) {
            System.out.println("Площадь фигуры: " + area);
        }
    }

    public static void task2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите исходную валюту:");
        System.out.println("1. Доллар\n2. Евро\n3. Фунт стерлингов\n4. Йена");
        int source = sc.nextInt();
        System.out.println("Выберите целевую валюту:");
        int target = sc.nextInt();
        System.out.println("Введите сумму для конвертации:");
        double amount = sc.nextDouble();

        double result = CurrencyConverter.convertCurrency(amount, source, target);
        System.out.println("Конвертированная сумма: " + result);
    }

    public static void task3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите операцию со строкой:");
        System.out.println("1. Проверка на палиндром");
        System.out.println("2. Подсчет количества гласных");
        System.out.println("3. Подсчет количества согласных");
        System.out.println("4. Подсчет количества вхождений слова");

        int op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1 -> {
                System.out.println("Введите строку:");
                System.out.println("Это палиндром? " + StringUtils.isPalindrome(sc.nextLine()));
            }
            case 2 -> {
                System.out.println("Введите строку:");
                System.out.println("Количество гласных: " + StringUtils.countVowels(sc.nextLine()));
            }
            case 3 -> {
                System.out.println("Введите строку:");
                System.out.println("Количество согласных: " + StringUtils.countConsonants(sc.nextLine()));
            }
            case 4 -> {
                System.out.println("Введите строку:");
                String text = sc.nextLine();
                System.out.println("Введите слово для поиска:");
                String word = sc.nextLine();
                System.out.println("Количество вхождений: " + StringUtils.countWordOccurrences(text, word));
            }
            default -> System.out.println("Неверный выбор");
        }
    }

    public static void task4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите исходную единицу длины:");
        System.out.println("1. Миллиметры\n2. Сантиметры\n3. Дециметры\n4. Метры\n5. Километры");
        int source = sc.nextInt();
        System.out.println("Выберите целевую единицу длины:");
        int target = sc.nextInt();
        System.out.println("Введите значение для конвертации:");
        double value = sc.nextDouble();

        double result = LengthConverter.convertLength(value, source, target);
        System.out.println("Конвертированное значение: " + result);
    }

    public static void task5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите исходную единицу веса:");
        System.out.println("1. Миллиграммы\n2. Граммы\n3. Килограммы\n4. Центнеры\n5. Тонны");
        int source = sc.nextInt();
        System.out.println("Выберите целевую единицу веса:");
        int target = sc.nextInt();
        System.out.println("Введите значение для конвертации:");
        double value = sc.nextDouble();

        double result = WeightConverter.convertWeight(value, source, target);
        System.out.println("Конвертированное значение: " + result);
    }
}

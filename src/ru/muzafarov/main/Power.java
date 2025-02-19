package ru.muzafarov.main;

/**
 * Класс для вычисления степени числа.
 */
public class Power {

    /**
     * Вычисляет x в степени y, где x и y заданы в виде строк.
     *
     * @param xStr Строка, представляющая основание степени.
     * @param yStr Строка, представляющая показатель степени.
     * @return Результат вычисления x^y.
     * @throws IllegalArgumentException Если входные строки не могут быть преобразованы в числа.
     * @throws ArithmeticException Если результат не может быть вычислен (например, 0^0).
     */
    public static double calculatePower(String xStr, String yStr) {
        try {
            double x = Double.parseDouble(xStr);
            double y = Double.parseDouble(yStr);
            return calculatePower(x, y);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректный формат числа: " + e.getMessage());
        }
    }

    /**
     * Вычисляет x в степени y.
     *
     * @param x Основание степени.
     * @param y Показатель степени.
     * @return Результат вычисления x^y.
     * @throws ArithmeticException Если результат не может быть вычислен (например, 0^0).
     */
    public static double calculatePower(double x, double y) {
        if (x == 0 && y == 0) {
            throw new ArithmeticException("Невозможно вычислить 0^0: неопределенное значение.");
        }
        return Math.pow(x, y);
    }

    /**
     * Пример использования класса Power.
     */
    public static void main(String[] args) {
        try {
            if (args.length < 2) {
                System.out.println("Использование: java ru.muzafarov.main.Power <X> <Y>");
                return;
            }

            String xStr = args[0];
            String yStr = args[1];

            double result = Power.calculatePower(xStr, yStr);
            System.out.printf("Результат: %.2f%n", result);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
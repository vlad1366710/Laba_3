package ru.muzafarov.main;

/**
 * ����� ��� ���������� ������� �����.
 */
public class Power {

    /**
     * ��������� x � ������� y, ��� x � y ������ � ���� �����.
     *
     * @param xStr ������, �������������� ��������� �������.
     * @param yStr ������, �������������� ���������� �������.
     * @return ��������� ���������� x^y.
     * @throws IllegalArgumentException ���� ������� ������ �� ����� ���� ������������� � �����.
     * @throws ArithmeticException ���� ��������� �� ����� ���� �������� (��������, 0^0).
     */
    public static double calculatePower(String xStr, String yStr) {
        try {
            double x = Double.parseDouble(xStr);
            double y = Double.parseDouble(yStr);
            return calculatePower(x, y);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("������������ ������ �����: " + e.getMessage());
        }
    }

    /**
     * ��������� x � ������� y.
     *
     * @param x ��������� �������.
     * @param y ���������� �������.
     * @return ��������� ���������� x^y.
     * @throws ArithmeticException ���� ��������� �� ����� ���� �������� (��������, 0^0).
     */
    public static double calculatePower(double x, double y) {
        if (x == 0 && y == 0) {
            throw new ArithmeticException("���������� ��������� 0^0: �������������� ��������.");
        }
        return Math.pow(x, y);
    }

    /**
     * ������ ������������� ������ Power.
     */
    public static void main(String[] args) {
        try {
            if (args.length < 2) {
                System.out.println("�������������: java ru.muzafarov.main.Power <X> <Y>");
                return;
            }

            String xStr = args[0];
            String yStr = args[1];

            double result = Power.calculatePower(xStr, yStr);
            System.out.printf("���������: %.2f%n", result);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println("������: " + e.getMessage());
        }
    }
}
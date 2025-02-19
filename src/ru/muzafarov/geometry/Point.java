package ru.muzafarov.geometry;

/**
 * �����, �������������� ����� � ��������� ������������.
 */
public class Point {
    private double x;
    private double y;

    /**
     * ������� ����� � ���������� ������������.
     *
     * @param x ���������� X.
     * @param y ���������� Y.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * ���������� ��������� ������������� �����.
     *
     * @return ��������� ������������� �����.
     */
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    /**
     * �������� ����� �� ��������� �������� �� ���� X � Y.
     *
     * @param deltaX ����� �� ��� X.
     * @param deltaY ����� �� ��� Y.
     */
    public void shift(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    /**
     * ���������� ��� ����� � ������ ��������.
     *
     * @param obj ������ ��� ���������.
     * @return true, ���� ������� �����, ����� false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point)) return false;
        Point other = (Point) obj;
        return Double.compare(x, other.x) == 0 && Double.compare(y, other.y) == 0;
    }

    /**
     * ���������� ���������� X �����.
     *
     * @return ���������� X.
     */
    public double getX() {
        return x;
    }

    /**
     * ������������� ���������� X �����.
     *
     * @param x ����� ���������� X.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * ���������� ���������� Y �����.
     *
     * @return ���������� Y.
     */
    public double getY() {
        return y;
    }

    /**
     * ������������� ���������� Y �����.
     *
     * @param y ����� ���������� Y.
     */
    public void setY(double y) {
        this.y = y;
    }
}
package ru.muzafarov.geometry;

import java.util.Objects;

/**
 * �����, �������������� ����� � ��������� ������������ � ������������ ������������.
 */
public class CloningPoint implements Cloneable {
    private double x;
    private double y;

    /**
     * ������� ����� � ���������� ������������.
     *
     * @param x ���������� X.
     * @param y ���������� Y.
     */
    public CloningPoint(double x, double y) {
        this.x = x;
        this.y = y;
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
     * ��������� ���������� �� ������ �����.
     *
     * @param other ������ �����.
     * @return ���������� �� ������ �����.
     * @throws IllegalArgumentException ���� ������ ����� ����� null.
     */
    public double distanceTo(CloningPoint other) {
        if (other == null) {
            throw new IllegalArgumentException("������ ����� �� ����� ���� null");
        }
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * ���������� ��������� ������������� �����.
     *
     * @return ��������� ������������� ����� � ������� "{x;y}".
     */
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
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
        if (obj == null || getClass() != obj.getClass()) return false;
        CloningPoint other = (CloningPoint) obj;
        return Double.compare(x, other.x) == 0 && Double.compare(y, other.y) == 0;
    }

    /**
     * ���������� ���-��� �����.
     *
     * @return ���-��� �����.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * ������� � ���������� ����� ���� �����.
     *
     * @return ����� ���� �����.
     * @throws CloneNotSupportedException ���� ������������ �� ��������������.
     */
    @Override
    public CloningPoint clone() throws CloneNotSupportedException {
        return (CloningPoint) super.clone();
    }
}
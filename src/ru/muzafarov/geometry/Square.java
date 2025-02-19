package ru.muzafarov.geometry;

/**
 * Класс, представляющий квадрат.
 */
public class Square extends Shape implements GeometryService {
    private Point topLeft;
    private double sideLength;

    /**
     * Создает квадрат по верхнему левому углу и длине стороны.
     *
     * @param topLeft    Верхний левый угол.
     * @param sideLength Длина стороны.
     * @throws IllegalArgumentException Если длина стороны отрицательная.
     */
    public Square(Point topLeft, double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны должна быть положительным числом.");
        }
        this.topLeft = topLeft;
        this.sideLength = sideLength;
    }

    /**
     * Создает квадрат по координатам верхнего левого угла и длине стороны.
     *
     * @param x          Координата X верхнего левого угла.
     * @param y          Координата Y верхнего левого угла.
     * @param sideLength Длина стороны.
     */
    public Square(double x, double y, double sideLength) {
        this(new Point(x, y), sideLength);
    }

    /**
     * Возвращает длину стороны квадрата.
     *
     * @return Длина стороны.
     */
    public double getSideLength() {
        return sideLength;
    }

    /**
     * Устанавливает длину стороны квадрата.
     *
     * @param sideLength Новая длина стороны.
     * @throws IllegalArgumentException Если длина стороны отрицательная.
     */
    public void setSideLength(double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны должна быть положительным числом.");
        }
        this.sideLength = sideLength;
    }

    /**
     * Возвращает периметр квадрата.
     *
     * @return Периметр квадрата.
     */
    @Override
    public double getLength() {
        return 4 * sideLength;
    }

    /**
     * Возвращает ломаную линию, представляющую квадрат.
     *
     * @return Ломаная линия.
     */
    @Override
    public Polyline getPolyline() {
        Point[] corners = new Point[4];
        corners[0] = topLeft;
        corners[1] = new Point(topLeft.getX() + sideLength, topLeft.getY());
        corners[2] = new Point(topLeft.getX() + sideLength, topLeft.getY() + sideLength);
        corners[3] = new Point(topLeft.getX(), topLeft.getY() + sideLength);
        return new Polyline(corners);
    }

    /**
     * Возвращает строковое представление квадрата.
     *
     * @return Строковое представление.
     */
    @Override
    public String toString() {
        return "Квадрат: верхний левый угол=" + topLeft + ", длина стороны=" + sideLength;
    }

    /**
     * Возвращает площадь квадрата.
     *
     * @return Площадь квадрата.
     */
    @Override
    public double area() {
        return sideLength * sideLength;
    }
}
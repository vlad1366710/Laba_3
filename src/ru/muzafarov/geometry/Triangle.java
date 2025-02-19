package ru.muzafarov.geometry;

/**
 * Класс, представляющий треугольник.
 */
public class Triangle extends Shape implements GeometryService {
    private double x1, y1;
    private double x2, y2;
    private double x3, y3;

    /**
     * Создает треугольник по координатам трех точек.
     *
     * @param x1 Координата X первой точки.
     * @param y1 Координата Y первой точки.
     * @param x2 Координата X второй точки.
     * @param y2 Координата Y второй точки.
     * @param x3 Координата X третьей точки.
     * @param y3 Координата Y третьей точки.
     */
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    /**
     * Возвращает площадь треугольника.
     *
     * @return Площадь треугольника.
     */
    @Override
    public double area() {
        double s = (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2;
        return Math.abs(s);
    }

    /**
     * Возвращает строковое представление треугольника.
     *
     * @return Строковое представление.
     */
    @Override
    public String toString() {
        return "Треугольник: точка1=(" + x1 + ", " + y1 + "), точка2=(" + x2 + ", " + y2 + "), точка3=(" + x3 + ", " + y3 + ")";
    }

    /**
     * Возвращает периметр треугольника.
     *
     * @return Периметр треугольника.
     */
    @Override
    public double getLength() {
        double side1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double side2 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double side3 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        return side1 + side2 + side3;
    }

    /**
     * Возвращает ломаную линию, представляющую треугольник.
     *
     * @return Ломаная линия.
     */
    @Override
    public Polyline getPolyline() {
        Point[] points = {
                new Point(x1, y1),
                new Point(x2, y2),
                new Point(x3, y3)
        };
        return new Polyline(points);
    }
}
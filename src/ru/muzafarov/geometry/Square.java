package ru.muzafarov.geometry;

public class Square extends Shape implements GeometryService {
    private Point topLeft;
    private double sideLength;

    public Square(Point topLeft, double sideLength) {
        setSideLength(sideLength);
        this.topLeft = topLeft;
    }

    public Square(double x, double y, double sideLength) {
        this(new Point(x, y), sideLength);
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны должна быть положительным числом.");
        }
        this.sideLength = sideLength;
    }

    @Override
    public double getLength() {
        return 4 * sideLength;
    }

    @Override
    public Polyline getPolyline() {
        Point[] corners = new Point[4];
        corners[0] = topLeft;
        corners[1] = new Point(topLeft.getX() + sideLength, topLeft.getY());
        corners[2] = new Point(topLeft.getX() + sideLength, topLeft.getY() + sideLength);
        corners[3] = new Point(topLeft.getX(), topLeft.getY() + sideLength);
        return new Polyline(corners);
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + sideLength;
    }

    @Override
    public double area() {
        return sideLength * sideLength;
    }
}

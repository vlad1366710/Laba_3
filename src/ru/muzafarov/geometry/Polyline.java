package ru.muzafarov.geometry;

public class Polyline implements GeometryService {

    private Point[] points;

    public Polyline(Point[] points) {
        this.points = points;
    }

    public Polyline() {
        this.points = new Point[0]; // Инициализация пустого массива
    }


    public Point getLastPoint() {
        return points[points.length - 1];
    }


    @Override public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i]);
            if (i < points.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public Point[] getPoints() {
        return points;
    }

    public double getLength() {
        double length = 0.0;
        for (int i = 0; i < points.length - 1; i++) {
            length += calculateDistance(points[i], points[i + 1]);
        }
        return length;
    }

    protected double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;


        if (!(obj instanceof Polyline)) return false;


        Polyline other = (Polyline) obj;


        if (this.points.length != other.points.length) return false;


        for (int i = 0; i < this.points.length; i++) {
            if (!this.points[i].equals(other.points[i])) {
                return false;
            }
        }

        return true;
    }


    @Override
    public Polyline getPolyline() {
        return this; // Возвращаем саму себя
    }
}
